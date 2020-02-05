package com.web.tutorial.hibernate;

import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Configuration
@PropertySource(value = "classpath:/database-test.properties")
@ComponentScan(basePackages = "com.web.tutorial.hibernate")
@ContextConfiguration(classes = HibernateConfig.class)
public class HibernateConfig
{
    @Autowired
    private Environment environment;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Bean
    DataSource dataSource()
    {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getRequiredProperty("database.connection.url.master"));
        driverManagerDataSource.setUsername(environment.getRequiredProperty("database.connection.username"));
        driverManagerDataSource.setPassword(environment.getRequiredProperty("database.connection.password"));
        driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("database.connection.driver"));
        return driverManagerDataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        jdbcTemplate.setQueryTimeout(60);
        return jdbcTemplate;
    }
}
