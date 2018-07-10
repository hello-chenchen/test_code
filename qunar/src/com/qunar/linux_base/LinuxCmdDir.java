package com.qunar.linux_base;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class LinuxCmdDir {
    private String directoryPath = null;
    private FilterType filterType = null;
    private String filterParam = null;

    public void setFilterParam(String filterParam) {
        this.filterParam = filterParam;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public enum FilterType{
        SuffixType, ContainsStarKey;
    }

    public LinuxCmdDir(String directoryPath, FilterType filterType, String filterParam) {
        this.directoryPath = directoryPath;
        this.filterType = filterType;
        this.filterParam = filterParam;
    }

    public List<LinuxCmdFile> listDirFiles() {
        List<LinuxCmdFile> linuxCmdFileList = new ArrayList<LinuxCmdFile>();
        File file = new File(directoryPath);
        if(!file.exists()) {
            System.out.println("debugLog: LinuxCmdDir listDirFiles file not exists");
            return linuxCmdFileList;
        }

        if(file.isFile()) {
            LinuxCmdFile linuxCmdFile = new LinuxCmdFile(file.getAbsolutePath());
            linuxCmdFileList.add(linuxCmdFile);
            return linuxCmdFileList;
        }

        for(File item : file.listFiles()) {
            if (item.isFile()) {
                fileFilter(linuxCmdFileList, item);
            }
        }

        return linuxCmdFileList;
    }

    private void fileFilter(List<LinuxCmdFile> linuxCmdFileList, File justFile) {
        if (FilterType.SuffixType == filterType) {
            LinuxCmdFile linuxCmdFile = new LinuxCmdFile(justFile.getAbsolutePath());
            linuxCmdFileList.add(linuxCmdFile);
        } else if (FilterType.ContainsStarKey == filterType) {
            if (justFile.getName().matches(filterParam.replaceAll("\\*", ".*"))) {
                LinuxCmdFile linuxCmdFile = new LinuxCmdFile(justFile.getAbsolutePath());
                linuxCmdFileList.add(linuxCmdFile);
            } else {
                System.out.println("debugLog: LinuxCmdDir listDirFiles filterParam " + filterType.name());
            }
        }
    }

    /**
     * @description:
     * FIXME: 递归调用容易爆栈
     */
    private void fileList(File file, List<LinuxCmdFile> linuxCmdFileList) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File item : files) {
                if(item.isFile()) {
                     fileFilter(linuxCmdFileList, item);
                }
                fileList(item, linuxCmdFileList);
            }
        }
    }
    public List<LinuxCmdFile> listRecursionDirFiles() {
        List<LinuxCmdFile> linuxCmdFileList = new ArrayList<LinuxCmdFile>();
        File file = new File(directoryPath);
        if(!file.exists()) {
            System.out.println("debugLog: LinuxCmdDir listDirFiles file not exists");
            return linuxCmdFileList;
        }

        fileList(file, linuxCmdFileList);

        return linuxCmdFileList;
    }
}
