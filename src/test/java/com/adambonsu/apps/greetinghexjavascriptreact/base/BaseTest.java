package com.adambonsu.apps.greetinghexjavascriptreact.base;

import com.adambonsu.apps.greetinghexjavascriptreact.config.AppiumConfig;
import utils.TestHelper;
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
    public abstract void setUp() throws Exception, InterruptedException;

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
        if(appiumConfig != null) {
            appiumConfig.stopService();
        }
    }
}
