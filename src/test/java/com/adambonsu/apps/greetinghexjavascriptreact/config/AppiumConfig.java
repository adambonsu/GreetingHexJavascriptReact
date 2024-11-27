package test.java.com.adambonsu.apps.greetinghexjavascriptreact.config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class AppiumConfig {
    private AppiumDriverLocalService service;
    private URL serverURL;

    public void startService() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
            .withAppiumJS(new File(System.getenv("APPIUM_MAIN_JS_PATH")))
            .withIPAddress(System.getenv("APPIUM_IP_ADDRESS"))
            .usingPort(Integer.parseInt(System.getenv("APPIUM_PORT")))
            .withArgument(GeneralServerFlag.BASEPATH, "/");
        service = builder.build();
        service.start();
        serverURL = service.getUrl();
    }

    public void stopService() {
        if (service != null) {
            service.stop();
        }
    }

    public URL getServerURL() {
        return serverURL;
    }
}
