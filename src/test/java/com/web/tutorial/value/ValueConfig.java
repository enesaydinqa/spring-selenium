package com.web.tutorial.value;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@PropertySource(value = "classpath:/twitter-client.properties")
@ComponentScan(basePackages = "com.web.tutorial.value")
@ContextConfiguration(classes = ValueConfig.class)
public class ValueConfig
{
}
