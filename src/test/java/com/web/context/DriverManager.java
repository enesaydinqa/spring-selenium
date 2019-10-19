package com.web.context;

import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverManager
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
