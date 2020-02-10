package com;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@Order(0)
@RunWith(SpringRunner.class)
@PropertySource(value =
        {
                "classpath:/log4j.properties",
                "classpath:/twitter-client.properties"
        })
@ComponentScan(basePackages = "com.web")
@ContextConfiguration(classes = HibernateConfiguration.class)
public class AppConfig
{
    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
