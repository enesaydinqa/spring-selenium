package com.web.tutorial.hibernate;

import com.web.tutorial.value.ValueAnnotationTest;
import org.apache.log4j.Logger;
import org.junit.Test;

public class HibernateTest extends HibernateConfig
{
    private static final Logger logger = Logger.getLogger(ValueAnnotationTest.class);

    @Test
    public void testHibernate()
    {
        logger.error(jdbcTemplate.queryForObject("SELECT first_name FROM users WHERE id=1".toUpperCase(), String.class));
    }
}
