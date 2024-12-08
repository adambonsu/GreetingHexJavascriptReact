#!/bin/bash

# Install dependencies
npm ci

# Set up JDK 17 (assuming Homebrew is installed)
brew install --cask temurin

# Set up Python (assuming Homebrew is installed)
brew install python@3

# Clean Android build
cd android
./gradlew clean
cd ..

# Find duplicate PackageList.java files
python scripts/find_duplicate_package_list_classes.py

# Remove duplicate PackageList.java files
duplicates=$(python scripts/find_duplicate_package_list_classes.py | grep -v "No duplicate")
if [ ! -z "$duplicates" ]; then
  echo "$duplicates" | while read -r file; do
    rm "$file"
    echo "Removed duplicate file: $file"
  done
fi

# Regenerate autolinking files
cd android
./gradlew generateAutolinkingPackageList
cd ..

# Clear Metro cache
rm -rf $TMPDIR/metro-*

# Build Android APK
cd android
./gradlew assembleRelease
