#!/bin/bash

# This script removes the -SNAPSHOT suffix from the version in build.sbt

# Path to the build.sbt file
BUILD_SBT_FILE="build.sbt"

# Check if the build.sbt file exists
if [ ! -f "$BUILD_SBT_FILE" ]; then
    echo "Error: build.sbt not found at $BUILD_SBT_FILE"
    exit 1
fi

# Use sed to remove -SNAPSHOT from the version string
sed -i 's/ThisBuild \/ version := "\(.*\)-SNAPSHOT"/ThisBuild \/ version := "\1"/' "$BUILD_SBT_FILE"

# Check if sed command was successful
if [ $? -ne 0 ]; then
    echo "Error: Failed to update version in $BUILD_SBT_FILE"
    exit 1
else
    echo "Updated version in $BUILD_SBT_FILE"
fi
