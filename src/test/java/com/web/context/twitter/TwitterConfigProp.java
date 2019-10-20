package com.web.context.twitter;

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
}
