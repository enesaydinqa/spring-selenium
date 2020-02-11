package com.mobile.context;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

@Configuration
public class AppiumServer
{
    private static final Logger logger = Logger.getLogger(AppiumServer.class);

    private static final String PORT = "8888";

    @Bean
    boolean startAppiumServer()
    {
        if (!checkIfServerIsRunning(PORT))
        {
            return startAppiumServer("127.0.0.1", PORT);
        }
        else
        {
            logger.info("already started appium server");
            return true;
        }
    }

    @Bean
    boolean removeDevicesApp()
    {
        // test devices remove app
        return true;
    }

    @Bean
    boolean removeDevicesUiAutomator()
    {
        // test devices remove removeDevicesUiAutomator
        return true;
    }

    private boolean startAppiumServer(String deviceServer, String devicePort)
    {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        try
        {
            if (Platform.getCurrent().is(Platform.MAC))
            {
                builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
            }

            builder.withIPAddress(deviceServer);
            builder.usingPort(Integer.valueOf(devicePort));
            builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

            AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
            service.start();
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    private boolean checkIfServerIsRunning(String port)
    {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try
        {
            serverSocket = new ServerSocket(Integer.valueOf(port));
            serverSocket.close();
        }
        catch (IOException e)
        {
            isServerRunning = true;
        }
        finally
        {
            serverSocket = null;
        }
        return isServerRunning;
    }
}
