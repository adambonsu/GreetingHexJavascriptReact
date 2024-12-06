package com.adambonsu.apps.greetinghexjavascriptreact.tests;

import java.util.Arrays;

import org.testng.annotations.BeforeClass;

import com.adambonsu.apps.greetinghexjavascriptreact.base.BaseTest;
import utils.IOS.AvailableSDKs;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSTest extends BaseTest {

    @Override  @BeforeClass
    public void setUp() throws Exception {
        super.setUp();

        XCUITestOptions options = new XCUITestOptions()
            .setDeviceName(System.getenv("DEVICE_NAME"))
            .setPlatformVersion(findHighestCompatibleSDKVersion(System.getenv("DEVICE_OS_VERSION")))
            .setUdid(prepareUDIDForAppium(System.getenv("DEVICE_UDID")))
            .setAutomationName("xcuitest")
            .setApp(System.getenv("APP_PATH"))
            .setPlatformName("iOS");

        logger.debug("Configuring driver..." + options);

        try{
            driver = new IOSDriver(appiumConfig.getRemoteServerURL(), options);
        } catch (Exception e) {
            logger.error("Error configuring driver: " + e.getMessage());
            throw e;
        }

        logger.debug("Configuring driver timeouts...");
        configureDriverTimeouts();
        logger.info("Set up completed");
    }

    private String prepareUDIDForAppium(String udid) {
        logger.info("Preparing UDID for Appium... targetSDKVersion: {}", udid);
        String result = udid;
        if (udid != null) {
            result = udid.replaceAll("-", "");
        }
        logger.debug("Prepared UDID: {}", result);
        return result;
    }

    private String findHighestCompatibleSDKVersion(String targetSDKVersion) {
        logger.info("Finding highest compatible SDK Version... targetSDKVersion: {}", targetSDKVersion);
        String[] availableSDKs = AvailableSDKs.getAvailableSDKs();
        logger.debug("availableSDKs: {}", Arrays.toString(availableSDKs));

        String compatibleVersion = targetSDKVersion;
        logger.debug("Initial compatibleVersion(highest available version): {}", compatibleVersion);
        if (targetSDKVersion != null && !targetSDKVersion.isEmpty()) {
            logger.debug("targetSDKVersion provided): {}. Find highest compatible SDK Version...", targetSDKVersion);
            compatibleVersion = availableSDKs[0];
            logger.debug("compatibleVersion(lowest available version): {}", compatibleVersion);
            for (String sdk : availableSDKs) {
                if(compareVersions(sdk, targetSDKVersion) <= 0 && compareVersions(sdk, compatibleVersion) > 0) {
                    compatibleVersion = sdk;
                    logger.debug("sdk match found. compatibleVersion: {}", compatibleVersion);
                }
            }
        }
        logger.info("Highest compatible SDK Version: {}", compatibleVersion);
        return compatibleVersion;
    }

    private int compareVersions(String v1, String v2) {
        String[] parts1 = v1.split("\\.");
        String[] parts2 = v2.split("\\.");
        int length = Math.max(parts1.length, parts2.length);
        for (int i = 0; i < length; i++) {
            int part1 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;
            int part2 = i < parts2.length ? Integer.parseInt(parts2[i]) : 0;
            if (part1 < part2) return -1;
            if (part1 > part2) return 1;
        }
        return 0;
    }
}
