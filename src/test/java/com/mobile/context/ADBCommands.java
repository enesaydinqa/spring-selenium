package com.mobile.context;

public enum ADBCommands
{
    ADB_DEVICES("adb devices");

    private String adbCommand;

    ADBCommands(String adbCommand)
    {
        this.adbCommand = adbCommand;
    }

    public String getAdbCommand()
    {
        return adbCommand;
    }
}
