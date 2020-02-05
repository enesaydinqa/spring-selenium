package com.web.test;

import com.web.test.TwitterTest;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.web.context.twitter.AbstractTwitterTest;

public class QueryTest extends AbstractTwitterTest
{
    private static final Logger logger = Logger.getLogger(TwitterTest.class);

    @Test
    public void testQuery(){
        logger.error(jdbcTemplate.queryForObject("SELECT first_name FROM users WHERE id=1".toUpperCase(), String.class));
    }
}
