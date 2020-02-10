package com.mobile.test;

import com.mobile.AbstractTest;
import com.mobile.context.ADBCommands;
import com.web.context.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SampleMobileTest extends AbstractTest
{
    private Logger logger = Logger.getLogger(DriverManager.class);

    public AppiumDriver androidDriver;

    private static final String createDriverUrl = "http://127.0.0.1:8888/wd/hub";

    @Before
    public void startApp() throws IOException, InterruptedException
    {
        DesiredCapabilities capability = new DesiredCapabilities();

        File appDir = new File("/opt/sahibinden/");
        File app = new File(appDir, "app-debug.apk");
        String uid = deviceManager.getDevicesUID().get(0);
        capability.setCapability("platformName", "Android");
        capability.setCapability("platformVersion", deviceManager.getDevicesInformation(ADBCommands.ADB_RO_BUILD_VERSION_RELEASE.getAdbCommand(), uid));
        capability.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capability.setCapability("udid", uid);
        capability.setCapability("deviceName", "Spring Tutorial Test Device");
        capability.setCapability("appPackage", "com.sahibinden");
        capability.setCapability("appActivity", "com.sahibinden.ui.supplementary.SplashScreenActivity");
        capability.setCapability("autoGrantPermissions", true);
        capability.setCapability("fastReset", true);
        capability.setCapability("noSign", true);
        capability.setCapability("noReset", false);
        capability.setCapability("automationName", "UiAutomator2");
        capability.setCapability("waitForAppScript", "$.delay(10000); $.acceptAlert();");
        capability.setCapability("keystorePath", "/opt/sahibinden/debug.keystore");

        URL url = new URL(createDriverUrl);

        androidDriver = new AndroidDriver(url, capability);
    }

    @Test
    public void testSample()
    {
        logger.info("STARTED TEST");
    }

    @After
    public void quitApp()
    {
        androidDriver.quit();
    }
}
