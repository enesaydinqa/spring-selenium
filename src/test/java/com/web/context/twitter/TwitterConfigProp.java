package com.web.context.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwitterConfigProp
{
    @Value("${test.user.name}")
    public String twitterUserName;

    @Value("${test.user.password}")
    public String twitterTestUserPassword;

    @Value("${base.url}")
    public String twitterBaseUrl;
}
