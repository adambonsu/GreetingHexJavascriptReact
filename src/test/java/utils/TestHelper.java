package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Timestamp;

public class TestHelper {
    private static final String GREETING_XPATH = "//*[@text='Hello Worldo!']";

    public static boolean isGreetingDisplayed(AppiumDriver driver) {
        try {
            System.out.println(new Timestamp(System.currentTimeMillis()) + ": DEBUG: isGreetingDisplayed(): 0");
            WebElement greetingElement = driver.findElement(By.xpath(GREETING_XPATH));
            System.out.println(new Timestamp(System.currentTimeMillis()) + ": DEBUG: isGreetingDisplayed(): 1: " + greetingElement.isDisplayed());
            return greetingElement.isDisplayed();
        } catch (Exception e) {
            System.out.println(new Timestamp(System.currentTimeMillis()) + ": DEBUG: isGreetingDisplayed(): 2: " + e.getMessage());
            return false;
        }
    }
}
