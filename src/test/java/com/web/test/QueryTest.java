package com.web.test;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.web.context.twitter.AbstractTwitterTest;
import org.apache.log4j.Logger.*;

public class QueryTest extends AbstractTwitterTest
{
    private static final Logger logger = Logger.getLogger(TwitterTest.class);

    @Test
    public void testQuery(){
        logger.info(jdbcTemplate.queryForObject("SELECT first_name FROM users WHERE id=1", String.class));
    }
}
