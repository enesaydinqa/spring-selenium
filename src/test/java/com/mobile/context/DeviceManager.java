package com.mobile.context;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceManager
{
    private static final Logger logger = Logger.getLogger(DeviceManager.class);

    public DeviceManager() throws IOException, InterruptedException
    {
        List<String> getDevicesUID = getDevicesUID();

        getDevicesUID.forEach(device ->
        {
            String deviceVersion = getDevicesInformation(ADBCommands.ADB_RO_BUILD_VERSION_RELEASE.getAdbCommand(), device);
            String deviceManufacturer = getDevicesInformation(ADBCommands.ADB_RO_PRODUCT_MANUFACTURER.getAdbCommand(), device);
            String deviceModel = getDevicesInformation(ADBCommands.ADB_RO_PRODUCT_MODEL.getAdbCommand(), device);

            logger.info("-----------------------------------------------------");
            logger.info("device uid : { " + device + " }");
            logger.info("device version : { " + deviceVersion + " }");
            logger.info("device manufacturer : { " + deviceManufacturer + " }");
            logger.info("device model : { " + deviceModel + " }");
            logger.info("-----------------------------------------------------");
        });
    }

    public List<String> getDevicesUID() throws IOException, InterruptedException
    {
        List<String> devicesUID = new ArrayList<>();

        String command = ADBCommands.ADB_DEVICES.getAdbCommand();

        Process procGetDeviceUID = Runtime.getRuntime().exec(command);

        try (BufferedReader processOutputReader =
                     new BufferedReader(new InputStreamReader(procGetDeviceUID.getInputStream())))
        {
            String readLine;

            while ((readLine = processOutputReader.readLine()) != null)
            {
                if (!readLine.contains("List") & readLine.contains("device"))
                {
                    String result = readLine.split("device")[0].trim();

                    devicesUID.add(result);
                }
            }
            procGetDeviceUID.waitFor();
        }

        return devicesUID;
    }

    public String getDevicesInformation(String adbCommand, String devicesUid)
    {
        String result = null;

        String command = String.format(adbCommand, devicesUid);

        try
        {
            Process procGetDeviceOperator = Runtime.getRuntime().exec(command);

            try (BufferedReader processOutputReader =
                         new BufferedReader(new InputStreamReader(procGetDeviceOperator.getInputStream())))
            {
                result = processOutputReader.readLine();

                procGetDeviceOperator.waitFor();
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        return result;
    }


}
