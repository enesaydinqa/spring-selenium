package com;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Order(0)
@PropertySource(value =
        {
                "classpath:/log4j.properties",
                "classpath:/twitter-client.properties"

        })
@ComponentScan(basePackages = "com")
@ContextConfiguration(classes = HibernateConfiguration.class)
public class AppConfig
{
    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
