package com.adambonsu.apps.greetinghexjavascriptreact;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.service.local.flags.GeneralServerFlag;

@Test
public class AndroidTest extends BaseTest {

    @Override
    public void setUp() throws Exception {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withAppiumJS(new File(System.getenv("APPIUM_MAIN_JS_PATH")))
        .withIPAddress(System.getenv("APPIUM_IP_ADDRESS"))
        .usingPort(Integer.parseInt(System.getenv("APPIUM_PORT")))
        .withArgument(GeneralServerFlag.BASEPATH, "/");
		
		service = builder.build();
		service.start();

        UiAutomator2Options options = new UiAutomator2Options()
            .setDeviceName("Pixel 9 API 35")
            .setAutomationName("uiautomator2")
            .setApp(System.getenv("ANDROID_APP_PATH"))
            .setPlatformName("Android");

        initializeDriver(options);
    }
}
