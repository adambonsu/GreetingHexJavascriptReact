package com.adambonsu.apps.greetinghexjavascriptreact.base;

import test.java.com.adambonsu.apps.greetinghexjavascriptreact.config.AppiumConfig;
import test.java.utils.TestHelper;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;


public abstract class BaseTest {
    protected AppiumDriver driver;
    protected AppiumConfig appiumConfig;

    @BeforeTest
    public abstract void setUp() throws Exception;

    protected void configureDriverTimeouts() {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        if(appiumConfig != null) {
            appiumConfig.stopService();
        }
    }
}
