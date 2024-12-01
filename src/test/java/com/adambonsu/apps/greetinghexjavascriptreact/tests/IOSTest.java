package com.adambonsu.apps.greetinghexjavascriptreact.tests;

import org.testng.annotations.BeforeClass;

import com.adambonsu.apps.greetinghexjavascriptreact.base.BaseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSTest extends BaseTest {

    @Override  @BeforeClass
    public void setUp() throws Exception {
        super.setUp();

        XCUITestOptions options = new XCUITestOptions()
            .setDeviceName(System.getenv("DEVICE_NAME"))
            .setPlatformVersion(System.getenv("DEVICE_OS_VERSION"))
            .setUdid(System.getenv("DEVICE_UDID"))
            .setAutomationName("xcuitest")
            .setApp(System.getenv("APP_PATH"))
            .setPlatformName("iOS");

        logger.debug("Configuring driver..." + options);

        try{
            driver = new IOSDriver(appiumConfig.getRemoteServerURL(), options);
        } catch (Exception e) {
            logger.error("Error configuring driver: " + e.getMessage());
            throw e;
        }

        logger.debug("Configuring driver timeouts...");
        configureDriverTimeouts();
        logger.info("Set up completed");
    }
}
