package com.mobile;

import com.mobile.context.MobileAppConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MobileAppConfig.class)
public abstract class AbstractTest
{

}
