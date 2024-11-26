package com.adambonsu.apps.greetinghexjavascriptreact;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertTrue;

import java.util.logging.*;

public abstract class BaseTest {
    protected AppiumDriver<MobileElement> driver;
    protected AppiumDriverLocalService service;
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @BeforeTest
    public abstract void setUp() throws Exception;

    @Test
    public void testGreetingDisplayed() {
        System.out.println("AGOB: BaseTest::testGreetingDisplayed() called");
        assertTrue(TestHelper.isGreetingDisplayed(driver), "Greeting is not displayed");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if(service != null) {
            service.stop();
        }
    }

    protected void initializeDriver(DesiredCapabilities capabilities) throws Exception {
        System.out.println("AGOB: BaseTest::initializeDriver()");
        try {
            FileHandler fileHandler = new FileHandler("appium_test.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.info("Initialising driver with capabilities: " + capabilities.toString());
            driver = new AppiumDriver<>(new URL("http://" + System.getenv("APPIUM_IP_ADDRESS") + ":" + System.getenv("APPIUM_PORT")), capabilities);
            logger.info("Driver initialised successfully" );

        } catch(Exception e) {
            logger.log(Level.SEVERE, "Failed to initialize driver" );
            throw e;
        }

        
    }
}
