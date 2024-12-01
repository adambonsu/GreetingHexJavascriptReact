package com.adambonsu.apps.greetinghexjavascriptreact.base;

import com.adambonsu.apps.greetinghexjavascriptreact.config.AppiumConfig;
import utils.TestHelper;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.sql.Timestamp;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseTest {
    protected AppiumDriver driver;
    protected AppiumConfig appiumConfig;
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeTest
    protected void setUp() throws Exception {
        logger.info("Setting up...");
        logger.debug("APPIUM_SERVER_MANAGEMENT:{}", System.getenv("APPIUM_SERVER_MANAGEMENT"));

        try {
            if(System.getenv("APPIUM_SERVER_MANAGEMENT") != null && System.getenv("APPIUM_SERVER_MANAGEMENT").toLowerCase().equals("true")) {
                logger.info("Configuring Appium service...");
                appiumConfig = new AppiumConfig();
                logger.debug("Starting Appium service...");
                appiumConfig.startService();
                logger.debug("Appium service started.");
            } else {
                logger.info("No Appium service setup configured by test.");
            }
        } catch (Exception e) {
            logger.error("Exception: {}", e);
            throw e;
        }
        
    }

    protected void configureDriverTimeouts() throws InterruptedException{
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
            // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }
    }

    @Test
    public void testGreetingDisplayed() {
        assertTrue(TestHelper.isGreetingDisplayed(driver), "Greeting is not displayed");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if(System.getenv("APPIUM_SERVER_MANAGEMENT") != null && System.getenv("APPIUM_SERVER_MANAGEMENT").toLowerCase().toLowerCase().equals("true")) {
            if(appiumConfig != null) {
                appiumConfig.stopService();
            }
        }  
    }
}
