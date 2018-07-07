package com.qunar.linux_base;

public class LinuxCmdDir {
    private String directoryPath = null;
    private String filterRegex = null;

    public LinuxCmdDir(String directoryPath, String filterRegex) {
        this.directoryPath = directoryPath;
        this.filterRegex = filterRegex;
    }

}
