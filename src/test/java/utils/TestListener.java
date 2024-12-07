package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.appium.java_client.AppiumDriver;
import com.adambonsu.apps.greetinghexjavascriptreact.base.BaseTest;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        AppiumDriver driver = ((BaseTest) testClass).getDriver();
        String testName = result.getName();
        
        System.getenv("TEST_SCREENSHOT_PATH");
        Screenshot.capture(driver, System.getenv("TEST_SCREENSHOT_PATH"), testName);
    }
    
}
