#!/bin/bash

# This script increments the minor version in build.sbt and throws an error if the version is a snapshot

# Path to the build.sbt file
BUILD_SBT_FILE="build.sbt"

# Check if the build.sbt file exists
if [ ! -f "$BUILD_SBT_FILE" ]; then
    echo "Error: build.sbt not found at $BUILD_SBT_FILE"
    exit 1
fi

# Extract the current version
current_version=$(grep 'ThisBuild / version :=' $BUILD_SBT_FILE | cut -d '"' -f 2)
if [ -z "$current_version" ]; then
    echo "Error: Unable to find the current version in $BUILD_SBT_FILE"
    exit 1
fi

# Check if current version is a snapshot
if [[ "$current_version" == *"-SNAPSHOT"* ]]; then
    echo "Error: Current version is a snapshot. Only stable versions should be processed."
    exit 1
fi

# Increment the minor version
IFS='.' read -ra VERSIONS <<< "$current_version"
major=${VERSIONS[0]}
minor=${VERSIONS[1]}
patch=${VERSIONS[2]}

let "minor+=1" # Increment the minor version
patch=0 # Reset patch number

# Create new version string with -SNAPSHOT
new_version="$major.$minor.$patch-SNAPSHOT"

# Replace the version in build.sbt
sed -i "s/ThisBuild \/ version := \"$current_version\"/ThisBuild \/ version := \"$new_version\"/" "$BUILD_SBT_FILE"


# Check if sed command was successful
if [ $? -ne 0 ]; then
    echo "Error: Failed to update version in $BUILD_SBT_FILE"
    exit 1
else
    echo "Updated version to $new_version in $BUILD_SBT_FILE"
fi
