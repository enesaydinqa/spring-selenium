package com.web.tutorial.value;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ValueAnnotationTest extends ValueConfig
{
    private static final Logger logger = Logger.getLogger(ValueAnnotationTest.class);

    @Autowired
    protected TwitterConfigProp twitterConfigProp;

    @Test
    public void propFileValueReadTest()
    {
        logger.info(twitterConfigProp.getBaseUrl());
    }
}