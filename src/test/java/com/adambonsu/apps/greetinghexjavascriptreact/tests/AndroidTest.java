package com.adambonsu.apps.greetinghexjavascriptreact.tests;

import com.adambonsu.apps.greetinghexjavascriptreact.base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AndroidTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(AndroidTest.class);

    @Override @BeforeClass
    public void setUp() throws Exception {
        super.setUp();

        UiAutomator2Options options = new UiAutomator2Options()
            .setDeviceName(System.getenv("DEVICE_NAME"))
            .setPlatformVersion(System.getenv("DEVICE_OS_VERSION"))
            .setUdid(System.getenv("DEVICE_UDID"))
            .setAutomationName("uiautomator2")
            .setApp(System.getenv("APP_PATH"))
            .setPlatformName("Android");
        
        logger.debug("Configuring driver..." + options);

        try{
            driver = new AndroidDriver(appiumConfig.getRemoteServerURL(), options);
        } catch (Exception e) {
            logger.error("Error configuring driver: " + e.getMessage());
            throw e;
        }
        
        logger.debug("Configuring driver timeouts...");
        configureDriverTimeouts();
        logger.info("Set up completed");

    }
}
