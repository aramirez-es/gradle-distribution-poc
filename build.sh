#!/usr/bin/env bash

# First, remove the custom distribution from the build dir and the one cached in gradle meta-data.
rm -rf ./custom-gradle-distribution/build
rm -rf $HOME/.gradle/wrapper/dists/custom-gradle-distro*


# Then, create the custom distribution.
cd ./custom-gradle-distribution
./gradlew build

cd ..
cd ./custom-gradle-plugin/
./gradlew publish

# Last, execute the parent build.
# Slower because --no-daemon but this ensure the previous distribution is not cached and it uses the new one.
cd ..
./gradlew build --no-daemon
