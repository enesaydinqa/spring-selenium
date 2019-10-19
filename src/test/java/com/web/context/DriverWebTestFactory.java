package com.web.context;

import org.apache.log4j.Logger;

public class DriverWebTestFactory
{
    private static final Logger logger = Logger.getLogger(DriverWebTestFactory.class);

    public static DriverManager getManager() throws Exception
    {
        DriverManager driverManager;

        BrowserType browserType = BrowserType.valueOf(System.getProperty("browser.type").toUpperCase());

        logger.info("BrowserType : " + browserType);

        switch (browserType)
        {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;

            default:
                throw new Exception("undefined browser type");
        }

        return driverManager;
    }
}
