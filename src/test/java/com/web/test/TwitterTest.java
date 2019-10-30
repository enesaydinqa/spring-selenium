package com.web.test;

import com.web.context.pages.twitter.LoginPage;
import com.web.context.twitter.AbstractTwitterTest;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TwitterTest extends AbstractTwitterTest
{
    private static final Logger logger = Logger.getLogger(TwitterTest.class);

    @Autowired
    LoginPage loginPage;

    @Test
    public void testSuccessfullyLogin()
    {
        loginPage
                .navigateToLoginPage()
                .usernameAndPasswordEnter(twitterConfigProp.testUserName, twitterConfigProp.testUserPassword)
                .loginButtonClick()
                .assertLoggedInUser();

        logger.info(jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=1", String.class));
    }


}