package com.web.context.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class Browser implements WebDriver
{
    private static final Logger logger = Logger.getLogger(Browser.class);

    private DriverManager driverManager;
    private WebDriverWait webDriverWait;

    @Autowired
    Browser(DriverManager driverManager)
    {
        this.driverManager = driverManager;
    }

    @Override
    public void get(String s)
    {
        driverManager.getWebDriver().get(s);
    }

    @Override
    public String getCurrentUrl()
    {
        return driverManager.getWebDriver().getCurrentUrl();
    }

    @Override
    public String getTitle()
    {
        return driverManager.getWebDriver().getTitle();
    }

    @Override
    public List<WebElement> findElements(By by)
    {
        return driverManager.getWebDriver().findElements(by);
    }

    @Override
    public WebElement findElement(By by)
    {
        return driverManager.getWebDriver().findElement(by);
    }

    @Override
    public String getPageSource()
    {
        return driverManager.getWebDriver().getPageSource();
    }

    @Override
    public void close()
    {
        driverManager.getWebDriver().close();
    }

    @Override
    public void quit()
    {
        driverManager.getWebDriver().quit();
    }

    @Override
    public Set<String> getWindowHandles()
    {
        return driverManager.getWebDriver().getWindowHandles();
    }

    @Override
    public String getWindowHandle()
    {
        return driverManager.getWebDriver().getWindowHandle();
    }

    @Override
    public TargetLocator switchTo()
    {
        return driverManager.getWebDriver().switchTo();
    }

    @Override
    public Navigation navigate()
    {
        return driverManager.getWebDriver().navigate();
    }

    @Override
    public Options manage()
    {
        return driverManager.getWebDriver().manage();
    }

    public void waitAndSendKeys(WebElement element, String keys)
    {
        waitUntilVisibilityOf(element);
        element.sendKeys(keys);
    }

    public void waitAndClick(WebElement element)
    {
        waitUntilVisibilityOf(element);
        waitUntilElementToClickable(element);
        element.click();
    }

    public void waitUntilVisibilityOf(WebElement element)
    {
        webDriverWait = new WebDriverWait(driverManager.getWebDriver(), 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementToClickable(WebElement element)
    {
        webDriverWait = new WebDriverWait(driverManager.getWebDriver(), 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPageLoadComplete()
    {
        logger.info("waiting for page load complete : " + getCurrentUrl());

        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        webDriverWait = new WebDriverWait(driverManager.getWebDriver(), 30);
        webDriverWait.until(pageLoadCondition);

        logger.info("page load ready state triggered");
    }

    public void sleep(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
