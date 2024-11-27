package com.adambonsu.apps.greetinghexjavascriptreact.tests;

import com.adambonsu.apps.greetinghexjavascriptreact.base.BaseTest;
import test.java.com.adambonsu.apps.greetinghexjavascriptreact.config.AppiumConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class AndroidTest extends BaseTest {

    @Override
    public void setUp() throws Exception {
        appiumConfig = new AppiumConfig();
        appiumConfig.startService();

        UiAutomator2Options options = new UiAutomator2Options()
            .setDeviceName(System.getenv("DEVICE_NAME"))
            .setAutomationName("uiautomator2")
            .setApp(System.getenv("APP_PATH"))
            .setPlatformName("Android");

        driver = new AndroidDriver(appiumConfig.getServerURL(), options);
        configureDriverTimeouts();

    }
}
