package com.web.context.driver;

import com.AppConfig;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverManager extends AppConfig
{
    protected static RemoteWebDriver driver;

    protected void createDriver()
    {
    }

    public RemoteWebDriver getDriver()
    {
        if (driver == null)
        {
            createDriver();
        }
        return driver;
    }
}
