package com.adambonsu.apps.greetinghexjavascriptreact.base;

import com.adambonsu.apps.greetinghexjavascriptreact.config.AppiumConfig;
import utils.TestHelper;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Listeners(utils.TestListener.class)
public abstract class BaseTest {
    protected AppiumDriver driver;
    protected AppiumConfig appiumConfig;
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeTest
    protected void setUp() throws Exception {
        logger.info("Setting up...");
        logger.debug("APPIUM_SERVER_MANAGEMENT:{}", System.getenv("APPIUM_SERVER_MANAGEMENT"));

        try {
            appiumConfig = new AppiumConfig(buildRemoteAddressFromEnvironmentVariables());
            if(System.getenv("APPIUM_SERVER_MANAGEMENT") != null && System.getenv("APPIUM_SERVER_MANAGEMENT").toLowerCase().equals("true")) {
                logger.info("Configuring Appium service...");
                logger.debug("Starting Appium service...");
                appiumConfig.startService();
                logger.debug("Appium service started.");
            } else {
                logger.info("Appium service setup not configured.");
            }
        } catch (Exception e) {
            logger.error("Exception: {}", e);
            throw e;
        }
        
    }

    private String buildRemoteAddressFromEnvironmentVariables() {
        String appiumRemoteAddress = "http://" + System.getenv("APPIUM_IP_ADDRESS") + ":" + System.getenv("APPIUM_PORT") + System.getenv("APPIUM_BASE_PATH");
        logger.debug("appiumRemoteAddress: {}", appiumRemoteAddress);
        return appiumRemoteAddress;
    }

    protected void configureDriverTimeouts() throws InterruptedException{
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        }
    }

    @Test
    public void testGreetingDisplayed() {
        assertTrue(TestHelper.isGreetingDisplayed(driver), "Greeting is not displayed");
    }

    @Test
    public void testGreetingEquals() {
        assertTrue(TestHelper.greetingEquals(driver, "Hello Worldo!"), "Greeting is not Hello Worldo!");
    }

    @AfterTest
    public void tearDown() {
        logger.info("Tearing down base...");
        if (driver != null) {
            logger.debug("Quitting driver...");
            driver.quit();
            logger.debug("Driver has quit.");
        }
        if(System.getenv("APPIUM_SERVER_MANAGEMENT") != null && System.getenv("APPIUM_SERVER_MANAGEMENT").toLowerCase().toLowerCase().equals("true")) {
            if(appiumConfig != null) {
                logger.debug("Stopping Appium service...");
                appiumConfig.stopService();
                logger.debug("Appium service stopped.");
            }
        }  
        logger.info("Base torn down.");
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
