# Android Build Script

This script automates the process of building an Android APK for our project. It handles dependency installation, environment setup, and the build process.

## Prerequisites

Before running this script, ensure you have the following installed on your Mac:

- Node.js and npm
- Homebrew
- Xcode Command Line Tools

## Usage

1. Save the script as `build_android.sh` in the `tools` directory of your project.

2. Make the script executable:
   ```bash
   chmod +x tools/build_android.sh
   ```

3. Run the script from the project root directory: `./tools/android/build.sh`

## What the Script Does
	1.	Installs npm dependencies
	2.	Sets up JDK 17 using Homebrew
	3.	Sets up Python 3.x using Homebrew
	4.	Cleans the Android build
	5.	Finds and removes duplicate PackageList.java files
	6.	Regenerates autolinking files
	7.	Clears the Metro cache
	8.	Builds the Android APK

## Troubleshooting
	•	If you encounter permission issues, ensure the script is executable.
	•	If Homebrew commands fail, make sure Homebrew is installed and updated.
	•	For any Java-related errors, verify that the JDK installation was successful.

## Notes
	•	This script assumes it’s run from the project root directory.
	•	It may take several minutes to complete, depending on your system and project size.
	•	The generated APK will be located in the `android/app/build/outputs/apk/release/` directory.

## Customization
You can modify the script to suit your specific project needs. Common customizations include:
	•	Changing the Java or Python versions
	•	Adding additional build steps or configurations
	•	Modifying the APK output location

For any questions or issues, please contact the development team.