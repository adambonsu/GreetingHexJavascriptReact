package com.adambonsu.apps.greetinghexjavascriptreact;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.service.local.flags.GeneralServerFlag;

@Test
public class AndroidTest extends BaseTest {

    @Override
    public void setUp() throws Exception {
        System.out.println("AGOB: AndroidTest::setUp() called");

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withAppiumJS(new File(System.getenv("APPIUM_MAIN_JS_PATH")))
        .withIPAddress(System.getenv("APPIUM_IP_ADDRESS"))
        .usingPort(Integer.parseInt(System.getenv("APPIUM_PORT")))
        .withArgument(GeneralServerFlag.BASEPATH, "/");
		
		service = builder.build();
		service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 9 API 35");
        capabilities.setCapability(MobileCapabilityType.APP, System.getenv("ANDROID_APP_PATH"));
        capabilities.setCapability("automationName", "uiautomator2");

        System.out.println("AGOB: Capabilities: " + capabilities.getCapability(MobileCapabilityType.APP).toString());
        initializeDriver(capabilities);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
