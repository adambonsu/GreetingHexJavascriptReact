# Developing

## Android

### Setting up local environment

1. Open a terminal and launch metro with `npx react-native start`
2. Open Android Studio
  2.1. Start a device (Add a new device if necessary): Tools => Device Manager
3. Run app against tests

### Testing locally
Execute following command via a terminal in the root directory of the project
```
APPIUM_IP_ADDRESS="127.0.0.1" \
APPIUM_PORT="4723" \
APPIUM_BASE_PATH="/" \
APPIUM_MAIN_JS_PATH="//PATH//TO//node_modules//appium//build//lib//main.js" \
APP_PATH=/PATH/TO/GreetingHexJavascriptReact/android/app/build/outputs/apk/release/app-release.apk \
DEVICE_NAME="Pixel 9 API 35" \
LOG_LEVEL=INFO \
APPIUM_SERVER_MANAGEMENT=true \
TEST_SCREENSHOT_PATH="." \
mvn test -Dtest=AndroidTest
```
* `APPIUM_IP_ADDRESS`
  Appium server's ip address

* `APPIUM_PORT`
  Appium server's port

* `APPIUM_BASE_PATH`
  Modern Appium server's have a "/" basepath. Legacy versions have "/wd/hub" as the basepath

* `APPIUM_MAIN_JS_PATH`
  1. Run the following command: `ls -l $(which appium)`. The output will show a symbolic link indicating the location of the main.js file
  2. Use the path from step 1 to create a full path to main.js

* `APP_PATH`
  Path to application (APK or IPA)

* `DEVICE_NAME`
  Name of Device

* `PLATFORM_NAME` (optional)

* `DEVICE_OS_VERSION` (optional)

* `DEVICE_UDID` (optional)

* `LOG_LEVEL` (optional)
  Logs configured to send to STDOUT and to `logs/application.log`. Log level can be configured using the `LOG_LEVEL` environment variable.

* `APPIUM_SERVER_MANAGEMENT` (optional)
  If 'true', test will start/stop the appium server for each test; otherwise the test suite assumes the appium server is running

### Building apk
```
cd android
./gradlew assembleRelease

```
This command will build a release APK here: `android/app/build/outputs/apk/release/app-release.apk`


## iOS

1. Open a terminal and launch metro with `npx react-native start`
2. Open Android Studio
  2.1. Start a device (Add a new device if necessary): Tools => Device Manager
3. Run app against tests
```
APPIUM_IP_ADDRESS="127.0.0.1" \
APPIUM_PORT="4723" \
APPIUM_BASE_PATH="/" \
APPIUM_MAIN_JS_PATH="//PATH//TO//node_modules//appium//build//lib//main.js" \
APP_PATH=./ios/GreetingHexJavascriptReact.ipa \
DEVICE_NAME="iPhone 16 Pro Max" \
LOG_LEVEL=INFO \
APPIUM_SERVER_MANAGEMENT=true \
TEST_SCREENSHOT_PATH="." \
mvn test -Dtest=IOSTest

```
The tests will be packaged in the target directory (`./target/tests-with-dependencies.zip`) if the package command completes successfully


### Building ipa
```
cd ios
xcodebuild -workspace GreetingHexJavascriptReact.xcworkspace -scheme GreetingHexJavascriptReact -configuration Release -archivePath GreetingHexJavascriptReact.xarchive archive -allowProvisioningUpdates
xcodebuild -exportArchive -archivePath GreetingHexJavascriptReact.xarchive.xcarchive -exportOptionsPlist exportOptions.plist -exportPath . -allowProvisioningUpdates

```
This command will build a release APK here: `ios/GreetingHexJavascriptReact.ipa`


### Packaging tests

Execute following command via a terminal in the root directory of the project
```
mvn clean package -DskipTests=true