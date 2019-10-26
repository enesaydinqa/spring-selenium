package com.mobile.context;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceManager
{
    public DeviceManager() throws IOException, InterruptedException
    {
        List<String> getDevicesUID = getDevicesUID();
    }

    private List<String> getDevicesUID() throws IOException, InterruptedException
    {
        List<String> devicesUID = new ArrayList<>();

        String command = ADBCommands.ADB_DEVICES.getAdbCommand();

        Process procGetDeviceUID = Runtime.getRuntime().exec(command);

        try (BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(procGetDeviceUID.getInputStream())))
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
}
