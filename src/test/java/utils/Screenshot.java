package utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {
    private static final Logger logger = LoggerFactory.getLogger(Screenshot.class);
    public static String capture(AppiumDriver driver, String directoryPath, String fileName) {
        logger.info("Capturing... driver: " + driver + ", directoryPath: " + directoryPath + ", fileName: " + fileName);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        logger.debug("timestamp: " + timestamp);
        new File(directoryPath).mkdirs();
        String filePath = directoryPath + fileName + "_" + timestamp + ".png";
        logger.debug("filePath: " + filePath);

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.debug("srcFile: " + srcFile);
            FileUtils.copyFile(srcFile, new File(filePath));
            logger.info("Screenshot captured: " + filePath);
            return filePath;
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
        
    }
    
}
