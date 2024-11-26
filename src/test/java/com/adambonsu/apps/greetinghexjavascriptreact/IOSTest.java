package com.adambonsu.apps.greetinghexjavascriptreact;

import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;

import io.appium.java_client.ios.options.XCUITestOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

@Test
public class IOSTest extends BaseTest {

    @Override
    public void setUp() throws Exception {

        XCUITestOptions options = new XCUITestOptions()
            .setDeviceName("iPhone Simulator")
            .setAutomationName("xcuitest")
            .setApp(System.getenv("IOS_APP_PATH"))
            .setPlatformName("iOS");

        initializeDriver(options);
    }
}
