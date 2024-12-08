#!/bin/bash

export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"  # This loads nvm

# Check if NVM is available
if type nvm > /dev/null 2>&1; then
    echo "NVM is installed. Setting up Node.js 20"
    nvm install 20
    nvm use 20
else
    echo "NVM is not installed or not properly sourced. Please install NVM first."
    exit 1
fi

# Verify Node.js version
node_version=$(node -v)
if [[ $node_version != v20* ]]; then
    echo "Failed to set Node.js 20. Current version: $node_version"
    exit 1
fi
echo "Node.js 20 is set up successfully. Current version: $node_version"

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
