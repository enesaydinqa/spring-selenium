package com.web.context.twitter;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.context.AbstractSeleniumTest;
import com.web.tutorial.value.TwitterConfigProp;

public class AbstractTwitterTest extends AbstractSeleniumTest
{
    @Autowired
    public TwitterConfigProp twitterConfigProp;
}