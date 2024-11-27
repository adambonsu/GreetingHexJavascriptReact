package com.adambonsu.apps.greetinghexjavascriptreact.tests;

import com.adambonsu.apps.greetinghexjavascriptreact.base.BaseTest;
import com.adambonsu.apps.greetinghexjavascriptreact.config.AppiumConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AndroidTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(AndroidTest.class);

    @Override @BeforeClass
    public void setUp() throws Exception {
        logger.info("Setting up AndroidTest...");
        appiumConfig = new AppiumConfig();
        logger.debug("Starting Appium service...");
        appiumConfig.startService();
        logger.debug("Appium service started.");

        UiAutomator2Options options = new UiAutomator2Options()
            .setDeviceName(System.getenv("DEVICE_NAME"))
            .setAutomationName("uiautomator2")
            .setApp(System.getenv("APP_PATH"))
            .setPlatformName("Android");
        
        logger.debug("Configuring driver..." + options);

        driver = new AndroidDriver(appiumConfig.getServerURL(), options);
        logger.debug("Configuring driver timeouts...");
        configureDriverTimeouts();
        logger.info("Set up completed");

    }
}
