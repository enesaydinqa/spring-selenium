package com.web;

import com.web.context.AbstractTwitterTest;
import org.junit.Test;

public class SampleTest extends AbstractTwitterTest
{
    @Test
    public void test()
    {
        System.out.println(twitterConfigProp.twitterUserName);
        System.out.println(twitterConfigProp.twitterTestUserPassword);
        System.out.println(twitterConfigProp.twitterBaseUrl);

    }
}