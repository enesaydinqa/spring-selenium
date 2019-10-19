package com.web.context.twitter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.web.context.twitter")
@PropertySource(value =
        {
                "classpath:/twitter-client.properties"
        })
public class TwitterAppConfiguration
{
}
