package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database-test.properties")
public class HibernateConfiguration
{
    @Autowired
    private Environment environment;

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
    JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setQueryTimeout(60);
        return jdbcTemplate;
    }
}
