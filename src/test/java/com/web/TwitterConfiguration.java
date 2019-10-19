package com.web;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("default")
@ContextConfiguration(classes = TwitterAppConfiguration.class)
public class TwitterConfiguration
{
    @Value("${test.user.name}")
    public String twitterUserName;

    @Value("${test.user.password}")
    public String twitterTestUserPassword;

    @Value("${base.url}")
    public String twitterBaseUrl;
}
