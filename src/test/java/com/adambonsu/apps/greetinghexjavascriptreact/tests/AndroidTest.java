package com.adambonsu.apps.greetinghexjavascriptreact.tests;

import com.adambonsu.apps.greetinghexjavascriptreact.base.BaseTest;
import com.adambonsu.apps.greetinghexjavascriptreact.config.AppiumConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import java.sql.Timestamp;

public class AndroidTest extends BaseTest {

    @Override @BeforeClass
    public void setUp() throws Exception {
        System.out.println(new Timestamp(System.currentTimeMillis()) + ": DEBUG: AndroidTest::setUp(): 0");
        appiumConfig = new AppiumConfig();
        System.out.println(new Timestamp(System.currentTimeMillis()) + ": DEBUG: AndroidTest::setUp(): 1");
        appiumConfig.startService();
        System.out.println(new Timestamp(System.currentTimeMillis()) + ": DEBUG: AndroidTest::setUp(): 2");

        UiAutomator2Options options = new UiAutomator2Options()
            .setDeviceName(System.getenv("DEVICE_NAME"))
            .setAutomationName("uiautomator2")
            .setApp(System.getenv("APP_PATH"))
            .setPlatformName("Android");
        
        System.out.println(new Timestamp(System.currentTimeMillis()) + ": DEBUG: AndroidTest::setUp(): 3");

        driver = new AndroidDriver(appiumConfig.getServerURL(), options);
        System.out.println(new Timestamp(System.currentTimeMillis()) + ": DEBUG: AndroidTest::setUp(): 4");
        configureDriverTimeouts();
        System.out.println(new Timestamp(System.currentTimeMillis()) + ": DEBUG: AndroidTest::setUp(): 5");

    }
}
