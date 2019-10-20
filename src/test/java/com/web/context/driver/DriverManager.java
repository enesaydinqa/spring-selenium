package com.web.context.driver;

import com.AppConfig;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager extends AppConfig
{
    protected static WebDriver driver;

    protected void createDriver()
    {
    }

    public WebDriver getWebDriver()
    {
        if (driver == null)
        {
            createDriver();
        }
        return driver;
    }

    public static WebDriver getDriver()
    {
        return driver;
    }
}
