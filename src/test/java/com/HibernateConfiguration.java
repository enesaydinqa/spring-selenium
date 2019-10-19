package com;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfiguration
{
    @Autowired
    private Environment environment;

    @Bean
    DataSource dataSource()
    {
        HikariConfig hikariConfig = new HikariConfig(hibernateProperties());
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    JdbcTemplate jdbcTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        jdbcTemplate.setQueryTimeout(60);
        return jdbcTemplate;
    }

    private Properties hibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("poolName", "SHBDN-MASTER");
        properties.put("jdbcUrl", environment.getRequiredProperty("database.connection.url.master"));
        properties.put("driverClassName", environment.getRequiredProperty("database.connection.driver"));
        properties.put("username", environment.getRequiredProperty("database.connection.username"));
        properties.put("password", environment.getRequiredProperty("database.connection.password"));
        properties.put("connectionTimeout", environment.getRequiredProperty("database.connection.connectionTimeout"));
        properties.put("maximumPoolSize", 3);
        properties.put("maxLifetime", environment.getRequiredProperty("database.connection.maxLifetime"));
        properties.put("idleTimeout", environment.getRequiredProperty("database.connection.idleTimeout"));
        properties.put("initializationFailFast", false);

        return properties;
    }
}
