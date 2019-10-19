package com.web.context;

import com.web.TwitterAppConfiguration;
import com.web.context.twitter.TwitterConfigProp;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TwitterAppConfiguration.class)
public class AbstractTwitterTest extends AbstractSeleniumTest
{
    @Autowired
    public TwitterConfigProp twitterConfigProp;
}
