package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

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
