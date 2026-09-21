#!/usr/bin/env python3
"""Summarise a JMH JSON result file, pairing the current and baseline arms.

Reads the JSON written by scripts/compare-benchmarks.sh and prints one row per
benchmark and parameter combination. When both arms are present the change is
reported with each arm's error, so a difference inside the noise is visible as
such rather than being read as an improvement.

Two tables are printed when -prof gc was collected. Allocation per operation is
close to deterministic, so it settles questions timing cannot: a change that adds
or removes an allocation moves B/op by an exact amount, while the same change can
sit well inside the run-to-run spread of wall time. Read allocation first.
"""

import argparse
import json
import sys
from pathlib import Path


def number(value):
    """JMH writes NaN as a string when a run has too few forks to estimate error."""
    try:
        result = float(value)
    except (TypeError, ValueError):
        return float("nan")
    return result


def format_score(measurement):
    if measurement is None:
        return "—"
    score, error = measurement
    return f"{score:,.1f}" if error != error else f"{score:,.1f} ± {error:,.1f}"


def label(row):
    name = row["benchmark"].split(".")[-2:]
    parameters = dict(row.get("params", {}))
    arm = parameters.pop("arm", "current")
    suffix = ", ".join(f"{key}={value}" for key, value in sorted(parameters.items()))
    return f"{name[0]}.{name[1]}" + (f" [{suffix}]" if suffix else ""), arm


# JMH renders this key with a leading middle dot in its console table but writes it plain in
# JSON. Accept both rather than depend on which one a given version emits.
ALLOCATION_METRICS = ("gc.alloc.rate.norm", "\u00b7gc.alloc.rate.norm")


def allocation_metric(row):
    secondary = row.get("secondaryMetrics", {})
    for name in ALLOCATION_METRICS:
        if name in secondary:
            return secondary[name]
    return None


def collect(rows, metric_of):
    """Pair arms for one metric. Returns (measurements, unit)."""
    measurements = {}
    unit = None
    for row in rows:
        metric = metric_of(row)
        if metric is None:
            continue
        unit = unit or metric.get("scoreUnit")
        key, arm = label(row)
        measurements.setdefault(key, {})[arm] = (number(metric["score"]), number(metric["scoreError"]))
    return measurements, unit


def print_table(measurements, unit, threshold, heading, note):
    if not measurements:
        return []
    print(heading)
    width = max(len(key) for key in measurements)
    paired = any("baseline" in arms for arms in measurements.values())
    if paired:
        print(f"{'benchmark'.ljust(width)}  {'baseline':>18}  {'current':>18}  {'change':>10}")
    else:
        print(f"{'benchmark'.ljust(width)}  {'current':>18}")

    regressions = []
    for key in sorted(measurements):
        arms = measurements[key]
        current = arms.get("current")
        baseline = arms.get("baseline")
        current_text = format_score(current)
        if not paired:
            print(f"{key.ljust(width)}  {current_text:>18}")
            continue
        baseline_text = format_score(baseline)
        if current and baseline and baseline[0]:
            change = (current[0] - baseline[0]) / baseline[0] * 100.0
            noise = 0.0 if current[1] != current[1] or baseline[1] != baseline[1] else current[1] + baseline[1]
            indistinguishable = abs(current[0] - baseline[0]) <= noise or abs(change) < threshold
            change_text = "~" if indistinguishable else f"{change:+.1f}%"
            if not indistinguishable and change > 0:
                regressions.append((key, change))
        elif current and baseline and not baseline[0]:
            change_text = "~" if not current[0] else "new"
        else:
            change_text = "\u2014"
        print(f"{key.ljust(width)}  {baseline_text:>18}  {current_text:>18}  {change_text:>10}")
    print(note)
    return regressions


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("results", type=Path, help="JMH JSON result file")
    parser.add_argument("--threshold", type=float, default=3.0,
                        help="Percent change in time treated as noise (default: 3)")
    parser.add_argument("--allocation-threshold", type=float, default=0.5,
                        help="Percent change in allocation treated as noise (default: 0.5)")
    arguments = parser.parse_args()

    rows = json.loads(arguments.results.read_text())
    for row in rows:
        if row["mode"] != "avgt":
            sys.exit("Expected average-time benchmarks")

    timings, time_unit = collect(rows, lambda row: row["primaryMetric"])
    if not timings:
        sys.exit("No benchmark results found")
    allocations, allocation_unit = collect(
        rows, allocation_metric)

    regressions = []
    if allocations:
        regressions += print_table(
            allocations, allocation_unit, arguments.allocation_threshold,
            "--- allocation ---",
            f"\nAllocation in {allocation_unit or 'B/op'}; lower is better. Near-deterministic, so "
            f"a '~' here is strong evidence of no change.\n")
    regressions += print_table(
        timings, time_unit, arguments.threshold,
        "--- time ---",
        f"\nTimes in {time_unit}; lower is better. '~' means within combined error "
        f"or under {arguments.threshold:g}%.")
    if not allocations:
        print("\nNo allocation data: rerun with -prof gc for a sharper signal than timing.")

    if regressions:
        print(f"\n{len(regressions)} measurement(s) worse than baseline:")
        for key, change in sorted(regressions, key=lambda item: -item[1]):
            print(f"  {key}  {change:+.1f}%")


if __name__ == "__main__":
    main()
