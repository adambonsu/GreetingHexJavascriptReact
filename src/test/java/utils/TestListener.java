package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.appium.java_client.AppiumDriver;
import com.adambonsu.apps.greetinghexjavascriptreact.base.BaseTest;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);
    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Starting onTestFailure...");
        Object testClass = result.getInstance();
        logger.debug("testClass: " + testClass);
        AppiumDriver driver = ((BaseTest) testClass).getDriver();
        logger.debug("driver: " + driver);
        String testName = result.getName();
        logger.debug("testName: " + testName);
        String screenshotPath = System.getenv("TEST_SCREENSHOT_PATH");
        logger.debug("screenshotPath: " + screenshotPath);
        Screenshot.capture(driver, screenshotPath, testName);
        logger.info("onTestFailure returning...");
    }
    
}
