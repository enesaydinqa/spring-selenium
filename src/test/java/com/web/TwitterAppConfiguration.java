package com.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.web.context")
@PropertySource(value = {"classpath:/twitter-client.properties"})
public class TwitterAppConfiguration
{
}
