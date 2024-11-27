package com.adambonsu.apps.greetinghexjavascriptreact.tests;

import com.adambonsu.apps.greetinghexjavascriptreact.base.BaseTest;
import test.java.com.adambonsu.apps.greetinghexjavascriptreact.config.AppiumConfig;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.Test;
import java.time.Duration;

@Test
public class IOSTest extends BaseTest {

    @Override
    public void setUp() throws Exception {
        appiumConfig = new AppiumConfig();
        appiumConfig.startService();

        XCUITestOptions options = new XCUITestOptions()
            .setDeviceName(System.getenv("DEVICE_NAME"))
            .setAutomationName("xcuitest")
            .setApp(System.getenv("APP_PATH"))
            .setPlatformName("iOS");

        driver = new IOSDriver(appiumConfig.getServerURL(), options);
        configureDriverTimeouts();
    }
}
