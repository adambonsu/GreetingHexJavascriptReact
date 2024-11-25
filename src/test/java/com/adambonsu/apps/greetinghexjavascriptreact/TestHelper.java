package com.adambonsu.apps.greetinghexjavascriptreact;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class TestHelper {
    public static boolean isGreetingDisplayed(AppiumDriver<MobileElement> driver) {
        try {
            MobileElement greetingElement = driver.findElement(By.xpath("//*[@text='Hello World']"));
            return greetingElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
