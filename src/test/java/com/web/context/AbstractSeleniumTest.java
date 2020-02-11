package com.web.context;

import com.AppConfig;
import com.web.context.driver.DriverManager;
import com.web.context.driver.DriverWebTestFactory;
import org.junit.After;
import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfig.class)
public class AbstractSeleniumTest extends DriverManager
{
    @Before
    public void setUp() throws Exception
    {
        init();
    }

    private void init() throws Exception
    {
        DriverManager driverManager;
        driverManager = DriverWebTestFactory.getManager();

        driver = driverManager.getWebDriver();
    }

    @After
    public void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }

}
