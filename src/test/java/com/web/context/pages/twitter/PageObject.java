package com.web.context.pages.twitter;

import com.web.context.driver.Browser;
import com.web.context.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PageObject
{
    PageObject(DriverManager driverManager)
    {
        PageFactory.initElements(driverManager.getWebDriver(), this);
    }

    @Autowired
    Browser browser;
}
