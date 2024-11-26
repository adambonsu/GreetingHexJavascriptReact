package com.adambonsu.apps.greetinghexjavascriptreact;

import org.openqa.selenium.WebElement;
// import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TestHelper {
    public static boolean isGreetingDisplayed(AppiumDriver driver) {
        try {
            WebElement greetingElement = driver.findElement(By.xpath("//*[@text='Hello Worldo!']"));
            return greetingElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
