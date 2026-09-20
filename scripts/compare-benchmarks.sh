#!/usr/bin/env bash
#
# Benchmarks the working tree's generated code against another revision's, in one JMH run.
#
# Both arms are generated from the same schemas in benchmarks/src/main/resources/avro. The
# baseline arm is generated inside a detached worktree of the comparison revision, with its
# namespace rewritten to avro2s.benchmarks.baseline so both can be loaded together. JMH forks
# each arm separately, so neither arm's presence perturbs the other's measurement.
#
# Usage:
#   scripts/compare-benchmarks.sh [options] [benchmark-filter]
#
#   benchmark-filter   JMH regex selecting benchmarks. Defaults to all shapes.
#
# Options:
#   --against <rev>    Revision to compare against (default: main)
#   --scala <list>     Comma-separated Scala versions: 2.13, 3 (default: 3,2.13)
#   --profile <name>   smoke | fast | full (default: full)
#                        smoke  one fork, 2 iterations: checks the harness runs, not for numbers
#                        fast   one fork, 5 iterations: ballpark, minutes rather than hours
#                        full   two forks, 10 iterations: the profile to quote
#   --sizes <list>     Comma-separated collectionSize values (default: the benchmarks' own sweep)
#   --current-only     Skip the baseline arm entirely
#   -h, --help         Show this message
#
# Results are written to benchmarks/results/, which is not tracked by git.
set -euo pipefail

REPOSITORY_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SBT="${AVRO2S_SBT:-sbt}"
BASELINE_REVISION="main"
SCALA_VERSIONS="3,2.13"
FILTER=".*"
PROFILE="full"
SIZES=""
CURRENT_ONLY=0

while [[ $# -gt 0 ]]; do
  case "$1" in
    --against) BASELINE_REVISION="$2"; shift 2 ;;
    --scala) SCALA_VERSIONS="$2"; shift 2 ;;
    --profile) PROFILE="$2"; shift 2 ;;
    --sizes) SIZES="$2"; shift 2 ;;
    --current-only) CURRENT_ONLY=1; shift ;;
    -h|--help) sed -n '2,30p' "${BASH_SOURCE[0]}" | sed 's/^# \{0,1\}//'; exit 0 ;;
    -*) echo "Unknown option: $1" >&2; exit 2 ;;
    *) FILTER="$1"; shift ;;
  esac
done

RESULTS_DIRECTORY="$REPOSITORY_ROOT/benchmarks/results"
mkdir -p "$RESULTS_DIRECTORY"

WORKTREE=""
cleanup() {
  if [[ -n "$WORKTREE" && -d "$WORKTREE" ]]; then
    git -C "$REPOSITORY_ROOT" worktree remove --force "$WORKTREE" >/dev/null 2>&1 || true
  fi
}
trap cleanup EXIT

project_for() {
  # sbt-projectmatrix names the default Scala version's project without a suffix.
  case "$1" in
    2.13) echo "benchmarks" ;;
    3) echo "benchmarks3" ;;
    *) echo "Unsupported Scala version: $1" >&2; exit 2 ;;
  esac
}

baseline_target_for() {
  case "$1" in
    2.13) echo "$REPOSITORY_ROOT/benchmarks/target/jvm-2.13/baseline-models" ;;
    3) echo "$REPOSITORY_ROOT/benchmarks/target/jvm-3/baseline-models" ;;
  esac
}

IFS=',' read -r -a VERSIONS <<< "$SCALA_VERSIONS"

if [[ "$CURRENT_ONLY" -eq 0 ]]; then
  if ! git -C "$REPOSITORY_ROOT" rev-parse --verify --quiet "$BASELINE_REVISION" >/dev/null; then
    echo "Cannot resolve revision '$BASELINE_REVISION'." >&2
    exit 1
  fi
  BASELINE_COMMIT="$(git -C "$REPOSITORY_ROOT" rev-parse "$BASELINE_REVISION")"
  WORKTREE="$(mktemp -d "${TMPDIR:-/tmp}/avro2s-baseline.XXXXXX")"
  rmdir "$WORKTREE"
  echo "==> Preparing baseline worktree for $BASELINE_REVISION ($BASELINE_COMMIT)"
  git -C "$REPOSITORY_ROOT" worktree add --detach "$WORKTREE" "$BASELINE_COMMIT" >/dev/null

  for VERSION in "${VERSIONS[@]}"; do
    TARGET="$(baseline_target_for "$VERSION")"
    rm -rf "$TARGET"
    mkdir -p "$TARGET"
    echo "==> Generating baseline models with $BASELINE_REVISION for Scala $VERSION"
    # The comparison revision has no benchmarks module, so its generator is driven by adding
    # this revision's GenerateBenchmarkModels to its test sources with an in-memory setting.
    # Nothing in the worktree's tracked files is modified.
    (
      cd "$WORKTREE"
      "$SBT" -batch \
        "set avro2s.jvm(\"2.13.16\") / Test / unmanagedSourceDirectories += file(\"$REPOSITORY_ROOT/benchmarks/generator\")" \
        "avro2s/Test/runMain GenerateBenchmarkModels $REPOSITORY_ROOT/benchmarks/src/main/resources/avro $TARGET $VERSION avro2s.benchmarks.baseline"
    )
    # The staged schema copies are generation inputs, not sources to compile.
    rm -rf "$TARGET/schemas"
  done
else
  for VERSION in "${VERSIONS[@]}"; do
    rm -rf "$(baseline_target_for "$VERSION")"
    mkdir -p "$(baseline_target_for "$VERSION")"
  done
fi

if [[ "$CURRENT_ONLY" -eq 1 ]]; then
  ARMS="current"
else
  ARMS="current,baseline"
fi

case "$PROFILE" in
  smoke) JMH_OPTIONS="-wi 1 -i 2 -r 1 -w 1 -f 1" ;;
  fast)  JMH_OPTIONS="-wi 2 -i 3 -r 1 -w 1 -f 1" ;;
  full)  JMH_OPTIONS="-wi 5 -i 5 -r 1 -w 1 -f 2" ;;
  *) echo "Unknown profile: $PROFILE (expected smoke, fast or full)" >&2; exit 2 ;;
esac

if [[ -n "$SIZES" ]]; then
  JMH_OPTIONS="$JMH_OPTIONS -p collectionSize=$SIZES"
fi

if [[ "$PROFILE" != "full" ]]; then
  echo "==> Profile '$PROFILE': indicative only. Use --profile full for numbers worth quoting."
fi

STATUS=0
for VERSION in "${VERSIONS[@]}"; do
  PROJECT="$(project_for "$VERSION")"
  OUTPUT="$RESULTS_DIRECTORY/scala-$VERSION.json"
  echo "==> Running JMH for Scala $VERSION (arms: $ARMS, filter: $FILTER)"
  if "$SBT" -batch "$PROJECT/Jmh/run $JMH_OPTIONS -p arm=$ARMS -rf json -rff $OUTPUT $FILTER"; then
    echo "==> Wrote $OUTPUT"
  else
    echo "==> JMH run failed for Scala $VERSION" >&2
    STATUS=1
  fi
done

for VERSION in "${VERSIONS[@]}"; do
  OUTPUT="$RESULTS_DIRECTORY/scala-$VERSION.json"
  if [[ -f "$OUTPUT" ]]; then
    echo
    echo "===== Scala $VERSION ====="
    python3 "$REPOSITORY_ROOT/scripts/summarize-benchmarks.py" "$OUTPUT" || STATUS=1
  fi
done

exit "$STATUS"
