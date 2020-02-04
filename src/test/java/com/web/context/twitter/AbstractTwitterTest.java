package com.web.context.twitter;

import com.AppConfig;
import com.web.context.AbstractSeleniumTest;
import com.web.test.value.TwitterConfigProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfig.class)
public class AbstractTwitterTest extends AbstractSeleniumTest
{
    @Autowired
    public TwitterConfigProp twitterConfigProp;
}