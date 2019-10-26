package com.mobile.context;

public enum ADBCommands
{
    ADB_DEVICES("adb devices"),
    ADB_RO_BUILD_VERSION_RELEASE("adb -s %s shell getprop ro.build.version.release");

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
