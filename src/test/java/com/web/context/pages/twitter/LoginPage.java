package com.web.context.pages.twitter;

import com.web.context.driver.DriverManager;
import com.web.context.pages.UrlFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends PageObject
{
    private static final Logger logger = Logger.getLogger(LoginPage.class);

    LoginPage(DriverManager driverManager)
    {
        super(driverManager);
    }

    @FindBy(xpath = "(//input[@name='session[username_or_email]'])[2]")
    private WebElement usernameOrEmailInput;

    @FindBy(xpath = "(//input[@name='session[password]'])[2]")
    private WebElement passwordInput;

    @FindBy(css = ".signin-wrapper .submit")
    private WebElement logInButton;

    public LoginPage navigateToLoginPage()
    {
        browser.navigate().to(UrlFactory.LOGIN_PAGE.pageUrl);
        return this;
    }

    public LoginPage usernameAndPasswordEnter(String username, String password)
    {
        logger.info("send keys username : " + username);
        browser.waitAndSendKeys(usernameOrEmailInput, username);
        logger.info("send keys password : " + password);
        browser.waitAndSendKeys(passwordInput, password);
        return this;
    }

    public LoginPage loginButtonClick()
    {
        browser.waitAndClick(logInButton);
        return this;
    }

    public LoginPage assertLoggedInUser() throws Exception
    {
        browser.sleep(5);
        browser.waitForPageLoadComplete();
        Assert.assertEquals(UrlFactory.HOME_PAGE.pageUrl, DriverManager.getDriver().getCurrentUrl());
        return this;
    }


}
