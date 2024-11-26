package com.adambonsu.apps.greetinghexjavascriptreact.tests;

import org.testng.annotations.BeforeClass;

import com.adambonsu.apps.greetinghexjavascriptreact.base.BaseTest;
import com.adambonsu.apps.greetinghexjavascriptreact.config.AppiumConfig;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSTest extends BaseTest {

    @Override  @BeforeClass
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
