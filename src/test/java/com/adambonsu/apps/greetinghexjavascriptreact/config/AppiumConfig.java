package com.adambonsu.apps.greetinghexjavascriptreact.config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppiumConfig {
    private AppiumDriverLocalService service;
    private URL remoteServerURL;
    private static final Logger logger = LoggerFactory.getLogger(AppiumConfig.class);

    public AppiumConfig(String appiumRemoteAddress) {
        try {
            remoteServerURL = new URL(appiumRemoteAddress);
        } catch(MalformedURLException e) {
            logger.error("Exception: {}", e);
        }

    }

    public void startService() {
        logger.info("Starting Appium service...");
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
            .withAppiumJS(new File(System.getenv("APPIUM_MAIN_JS_PATH")))
            .withIPAddress(System.getenv("APPIUM_IP_ADDRESS"))
            .usingPort(Integer.parseInt(System.getenv("APPIUM_PORT")))
            .withArgument(GeneralServerFlag.BASEPATH, "/");
        logger.debug("Building Appium service: {}", builder);
        service = builder.build();
        logger.debug("Starting service...");
        service.start();
        logger.debug("Getting server URL...");
        remoteServerURL = service.getUrl();
        logger.info("Appium service started on URL: {}", remoteServerURL);
    }

    public void stopService() {
        if (service != null) {
            service.stop();
        }
    }

    public URL getRemoteServerURL() {
        logger.debug("getRemoteServerURL(): remoteServerURL: {}", remoteServerURL);
        return remoteServerURL;
    }
}
