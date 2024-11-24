package functional.java.com.adambonsu.apps.greetinghexjavascriptreact;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertTrue;

public abstract class BaseTest {
    protected AppiumDriver<MobileElement> driver;

    @BeforeTest
    public abstract void setUp() throws Exception;

    @Test
    public void testGreetingDisplayed() {
        assertTrue(TestHelper.isGreetingDisplayed(driver), "Greeting is not displayed");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void initializeDriver(DesiredCapabilities capabilities) throws Exception {
        driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
