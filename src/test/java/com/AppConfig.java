package com;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@PropertySource(value =
        {
                "classpath:/log4j.properties",
                "classpath:/database-test.properties"
        })
@ContextConfiguration(classes = HibernateConfiguration.class)
public class AppConfig
{
    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
