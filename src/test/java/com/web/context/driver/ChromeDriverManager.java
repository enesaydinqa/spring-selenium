package com.web.context.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager extends DriverManager
{
    private static final Logger logger = Logger.getLogger(ChromeDriverManager.class);

    private ChromeOptions chromeOptions;
    private DesiredCapabilities desiredCapabilities;

    @Override
    public void createDriver()
    {
        chromeOptions = chromeOptions();

        desiredCapabilities = desiredCapabilities(chromeOptions);

        if (Platform.getCurrent().is(Platform.MAC))
        {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        }
        else if (Platform.getCurrent().is(Platform.WINDOWS))
        {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        }

        driver = new ChromeDriver(desiredCapabilities);
    }

    private DesiredCapabilities desiredCapabilities(ChromeOptions chromeOptions)
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return capabilities;
    }

    private ChromeOptions chromeOptions()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--window-size=1400,800");
        Map<String, Object> prefs = new HashMap<>();
        chromeOptions.setExperimentalOption("prefs", prefs);

        return chromeOptions;
    }
}
