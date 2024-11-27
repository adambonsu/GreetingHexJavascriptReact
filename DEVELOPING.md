# Developing

```
APPIUM_IP_ADDRESS="127.0.0.1" \
APPIUM_PORT="4723" \
APPIUM_MAIN_JS_PATH="//PATH//TO//node_modules//appium//build//lib//main.js" \
APP_PATH=/PATH/TO/GreetingHexJavascriptReact/android/app/build/outputs/apk/release/app-release.apk \
DEVICE_NAME="Pixel 9 API 35" \
LOG_LEVEL=INFO \
mvn test -Dtest=AndroidTest
```
* `APPIUM_IP_ADDRESS`
  Appium server's ip address

* `APPIUM_PORT`
  Appium server's port

* `APPIUM_MAIN_JS_PATH`
  1. Run the following command: `ls -l $(which appium)`. The output will show a symbolic link indicating the location of the main.js file
  2. Use the path from step 1 to create a full path to main.js

* `APP_PATH`
  Path to application (APK or )

* `DEVICE_NAME`
  Name of Device

* `LOG_LEVEL` (optional)
  Logs configured to send to STDOUT and to `logs/application.log`. Log level can be configured using the `LOG_LEVEL` environment variable.