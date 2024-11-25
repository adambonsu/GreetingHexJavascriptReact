package com.adambonsu.apps.greetinghexjavascriptreact;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

@Test
public class AndroidTest extends BaseTest {

    @Override
    public void setUp() throws Exception {
        System.out.println("AGOB: AndroidTest::setUp() called");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.APP, System.getenv("ANDROID_APP_PATH"));
        capabilities.setCapability("automationName", "uiautomator2");

        System.out.println("AGOB: Capabilities: " + capabilities.toString());
        initializeDriver(capabilities);
    }
}
