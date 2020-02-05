package com.web.tutorial.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwitterConfigProp
{
    @Value("${test.user.name}")
    public String testUserName;

    @Value("${test.user.password}")
    public String testUserPassword;

    @Value("${base.url}")
    public String baseUrl;

    public String getTestUserName()
    {
        return testUserName;
    }

    public void setTestUserName(String testUserName)
    {
        this.testUserName = testUserName;
    }

    public String getTestUserPassword()
    {
        return testUserPassword;
    }

    public void setTestUserPassword(String testUserPassword)
    {
        this.testUserPassword = testUserPassword;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl)
    {
        this.baseUrl = baseUrl;
    }
}
