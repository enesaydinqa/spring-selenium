package com.mobile.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.mobile")
@PropertySource(value = {"classpath:/log4j.properties"})
public class MobileAppConfig
{
    @Autowired
    private DeviceManager deviceManager;
}
