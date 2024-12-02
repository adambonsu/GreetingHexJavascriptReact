package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adambonsu.apps.greetinghexjavascriptreact.config.AppiumConfig;

public class TestHelper {
    private static final String GREETING_XPATH = "//*[@text='Hello Worldo!']";
    private static final Logger logger = LoggerFactory.getLogger(AppiumConfig.class);

    public static boolean isGreetingDisplayed(AppiumDriver driver) {
        try {
            logger.info("isGreetingDisplayed() Starting...");
            WebElement greetingElement = driver.findElement(By.xpath(GREETING_XPATH));
            logger.debug("isGreetingDisplayed(): {}}", greetingElement.isDisplayed());
            return greetingElement.isDisplayed();
        } catch (Exception e) {
            logger.error("Exception in isGreetingDisplayed: {}", e);
            return false;
        }
    }
}
