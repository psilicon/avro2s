#!/usr/bin/env python3
"""Summarise a JMH JSON result file, pairing the current and baseline arms.

Reads the JSON written by scripts/compare-benchmarks.sh and prints one row per
benchmark and parameter combination. When both arms are present the change is
reported with each arm's error, so a difference inside the noise is visible as
such rather than being read as an improvement.
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


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("results", type=Path, help="JMH JSON result file")
    parser.add_argument("--threshold", type=float, default=3.0,
                        help="Percent change treated as noise (default: 3)")
    arguments = parser.parse_args()

    rows = json.loads(arguments.results.read_text())
    measurements = {}
    unit = None
    for row in rows:
        metric = row["primaryMetric"]
        if row["mode"] != "avgt":
            sys.exit("Expected average-time benchmarks")
        unit = unit or metric["scoreUnit"]
        key, arm = label(row)
        measurements.setdefault(key, {})[arm] = (number(metric["score"]), number(metric["scoreError"]))

    if not measurements:
        sys.exit("No benchmark results found")

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
            # Treat a change smaller than the combined error as indistinguishable.
            # A NaN error means JMH could not estimate one, so fall back to the threshold alone.
            noise = 0.0 if current[1] != current[1] or baseline[1] != baseline[1] else current[1] + baseline[1]
            indistinguishable = abs(current[0] - baseline[0]) <= noise or abs(change) < arguments.threshold
            change_text = "~" if indistinguishable else f"{change:+.1f}%"
            if not indistinguishable and change > 0:
                regressions.append((key, change))
        else:
            change_text = "—"
        print(f"{key.ljust(width)}  {baseline_text:>18}  {current_text:>18}  {change_text:>10}")

    print(f"\nTimes in {unit}; lower is better. '~' means within combined error "
          f"or under {arguments.threshold:g}%.")
    if regressions:
        print(f"\n{len(regressions)} benchmark(s) slower than baseline:")
        for key, change in sorted(regressions, key=lambda item: -item[1]):
            print(f"  {key}  {change:+.1f}%")


if __name__ == "__main__":
    main()
