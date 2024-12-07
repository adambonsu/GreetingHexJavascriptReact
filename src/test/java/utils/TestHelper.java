package utils;

import io.appium.java_client.AppiumDriver;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestHelper {
    private static final String GREETING_XPATH = "//*[@text='Hello Worldo!' or @label='Hello Worldo!' or @name='Hello Worldo!']";
    private static final Logger logger = LoggerFactory.getLogger(TestHelper.class);

    public static boolean isGreetingDisplayed(AppiumDriver driver) {
        try {
            logger.info("isGreetingDisplayed() Starting...");
            logger.debug("driver: " + driver);
            WebElement greetingElement = driver.findElement(By.xpath(GREETING_XPATH));
            logger.debug("greetingElement: " + greetingElement);
            boolean isDisplayed = greetingElement.isDisplayed();
            logger.debug("isDisplayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.error("Exception in isGreetingDisplayed: " + e);
            logger.error("Page Source: " + driver.getPageSource());
            return false;
        }
    }
}
