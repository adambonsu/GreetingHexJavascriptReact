package com.adambonsu.apps.greetinghexjavascriptreact;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertTrue;

import java.util.logging.*;
import io.appium.java_client.ios.IOSDriver;

public abstract class BaseTest {
    protected AppiumDriver driver;
    protected AppiumDriverLocalService service;
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @BeforeTest
    public abstract void setUp() throws Exception;

    @Test
    public void testGreetingDisplayed() {
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

    protected void initializeDriver(BaseOptions options) throws Exception {
        try {
            if(options instanceof UiAutomator2Options) {
                driver = new AndroidDriver(
                    new URL("http://" + System.getenv("APPIUM_IP_ADDRESS") + ":" + System.getenv("APPIUM_PORT")),
                    options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            } else if(options instanceof XCUITestOptions) {
                driver = new IOSDriver(
                    new URL("http://" + System.getenv("APPIUM_IP_ADDRESS") + ":" + System.getenv("APPIUM_PORT")),
                    options);
                FileHandler fileHandler = new FileHandler("appium_test.log");
                fileHandler.setFormatter(new SimpleFormatter());
                driver = new AppiumDriver(
                    new URL("http://" + System.getenv("APPIUM_IP_ADDRESS") + ":" + System.getenv("APPIUM_PORT")),
                        options);
            }  else {
                driver = new AppiumDriver(
                    new URL("http://" + System.getenv("APPIUM_IP_ADDRESS") + ":" + System.getenv("APPIUM_PORT")),
                    options);
                FileHandler fileHandler = new FileHandler("appium_test.log");
                fileHandler.setFormatter(new SimpleFormatter());
                driver = new AppiumDriver(
                    new URL("http://" + System.getenv("APPIUM_IP_ADDRESS") + ":" + System.getenv("APPIUM_PORT")),
                        options);
            }
        } catch(Exception e) {
            throw e;
        }

        
    }
}
