package test.java.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestHelper {
    private static final String GREETING_XPATH = "//*[@text='Hello Worldo!']";

    public static boolean isGreetingDisplayed(AppiumDriver driver) {
        try {
            WebElement greetingElement = driver.findElement(By.xpath(GREETING_XPATH));
            return greetingElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
