package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestHelper {
    private static final Logger logger = LoggerFactory.getLogger(TestHelper.class);

    public static boolean isGreetingDisplayed(AppiumDriver driver) {
        logger.info("isGreetingDisplayed() Starting...");
        boolean result = getGreetingElement(driver).isDisplayed();
        logger.debug("result: " + result);
        return result;
    }

    public static boolean greetingEquals(AppiumDriver driver, String expectedGreeting) {
        logger.info("greetingEquals() Starting...");
        boolean result = getGreetingElement(driver).getText().equals(expectedGreeting);
        logger.debug("result: " + result);
        return result;
    }

    public static WebElement getGreetingElement(AppiumDriver driver) {
        try {
            logger.info("getGreetingElement() Starting...");
            logger.debug("driver: " + driver);
            WebElement greetingElement = driver.findElement(AppiumBy.accessibilityId("greeting"));
            logger.debug("greetingElement: " + greetingElement);
            return greetingElement;
        } catch (Exception e) {
            logger.error("Exception: " + e);
            logger.error("Page Source: " + driver.getPageSource());
            return null;
        }
    }
}
