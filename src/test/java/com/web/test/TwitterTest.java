package com.web.test;

import com.web.context.twitter.AbstractTwitterTest;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TwitterTest extends AbstractTwitterTest
{
    private static final Logger logger = Logger.getLogger(TwitterTest.class);

    @Test
    public void test()
    {
        logger.info(twitterConfigProp.twitterUserName);
        logger.info(twitterConfigProp.twitterTestUserPassword);
        logger.info(twitterConfigProp.twitterBaseUrl);
    }
}