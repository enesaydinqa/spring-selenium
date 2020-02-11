package com.web.tutorial.hibernate;

import com.web.tutorial.value.ValueAnnotationTest;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Configuration
@ContextConfiguration(classes = BeanSample.class)
public class BeanSample
{
    private static final Logger logger = Logger.getLogger(ValueAnnotationTest.class);

    @Bean
    String firstBean()
    {
        logger.info("firstBean çalıştı");

        return "firstBean";
    }

    @Bean
    Integer secondBean()
    {
        logger.info("secondBean çalıştı");

        return 0;
    }

    @Bean
    Double thirdBean()
    {
        logger.info("thirdBean çalıştı");

        return 0.0;
    }

    @Bean
    CharSequence fourthBean()
    {
        logger.info("fourthBean çalıştı");

        return "fourthBean";
    }
}
