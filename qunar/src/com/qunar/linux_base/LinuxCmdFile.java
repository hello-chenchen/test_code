package com.qunar.linux_base;

public class LinuxCmdFile {
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileName = null;

    public LinuxCmdFile(String filename) {
        this.fileName = filename;
    }
}
