package com.adambonsu.apps.greetinghexjavascriptreact;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

@Test
public class IOSTest extends BaseTest {

    @Override
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        capabilities.setCapability(MobileCapabilityType.APP, System.getenv("IOS_APP_PATH"));
        capabilities.setCapability("automationName", "xcuitest");

        initializeDriver(capabilities);
    }
}
