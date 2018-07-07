package com.qunar.command;

import com.qunar.command.CommandOption;
import com.qunar.command.ExecuteType;
import com.qunar.command.LinuxCmd;
import com.qunar.linux_base.LinuxCmdDir;
import com.qunar.linux_base.LinuxCmdFile;
import com.qunar.linux_util.BaseUtil;

import java.io.*;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * Usage: cat [OPTION]... [FILE]...
 * Concatenate FILE(s) to standard output.
 *
 * With no FILE, or when FILE is -, read standard input.
 *
 *   -A, --show-all           equivalent to -vET
 *   -b, --number-nonblank    number nonempty output lines, overrides -n
 *   -e                       equivalent to -vE
 *   -E, --show-ends          display $ at end of each line
 *   -n, --number             number all output lines
 *   -s, --squeeze-blank      suppress repeated empty output lines
 *   -t                       equivalent to -vT
 *   -T, --show-tabs          display TAB characters as ^I
 *   -u                       (ignored)
 *   -v, --show-nonprinting   use ^ and M- notation, except for LFD and TAB
 *       --help     display this help and exit
 *       --version  output version information and exit
 */
public class Cat extends LinuxCmd {
    //TODO：功能太多,仅实现-A, -E, -T, -t, -n
    //TODO: 未实现的功能:optionAndbHandle,optionAndsHandle,optionAnduHandle,optionAndvHandle
    public enum CatExecuteOption implements CommandOption {
        optionAndAHandle, optionAndeHandle, optionAndEHandle, optionAndnHandle,
        optionAndtHandle, optionAndTHandle;
    }

    public enum CatExecuteType implements ExecuteType {
        filesHandle, optionAndFilesHandle,
        directorysHandle, optionAndDirectorysHandle;
    }

    //FIXME:为了实现execute和optionHandle的反射必须实例化无参构造函数
    public Cat() {}

//    public Cat(String standardInPut) {
//        this.executeType = CommonExecuteType.standardInPutHandle;
//        this.operateObject = standardInPut;
//    }
//
//    public Cat(Set<CommandOption> options, String standardInPut) {
//        this.executeType = CommonExecuteType.optionAndStandardInPutHandle;
//        this.operateObject = standardInPut;
//        this.optionList = options;
//    }

    public Cat(LinuxCmdFile... files) {
        init();
        this.executeType = CatExecuteType.filesHandle;
        for (LinuxCmdFile item : files) {
            this.linuxCmdFileList.add(item);
        }
    }

    public Cat(Set<CommandOption> options, LinuxCmdFile... files) {
        init();
        this.executeType = CatExecuteType.optionAndFilesHandle;
        this.optionList = options;
        for (LinuxCmdFile item : files) {
            linuxCmdFileList.add(item);
        }
    }

    public Cat(LinuxCmdDir... dirPath) {
        init();
        this.executeType = CatExecuteType.directorysHandle;
        for (LinuxCmdDir item : dirPath) {
            linuxCmdDirList.add(item);
        }
    }

    public Cat(Set<CommandOption> options, LinuxCmdDir... dirPath) {
        init();
        this.executeType = CatExecuteType.optionAndDirectorysHandle;
        this.optionList = options;
        for (LinuxCmdDir item : dirPath) {
            linuxCmdDirList.add(item);
        }
    }

    @Override
    public void init() {
        super.init();
        for(CatExecuteType item : CatExecuteType.values()) {
            executeMap.put(item, item.name());
        }

        for(CatExecuteOption item : CatExecuteOption.values()) {
            optionExecuteMap.put(item, item.name());
        }
    }

    public void filesHandle() {
        if(this.linuxCmdFileList.size() <= 0) {
            System.out.println("debugLog:Cat No Such Files");
            return;
        }

        this.operateObject = BaseUtil.readFiles(linuxCmdFileList);
    }

    public void optionAndFilesHandle() {
        filesHandle();
        super.optionHandle();
    }

    public void directorysHandle() {
        //TODO:

    }

    public void optionAndDirectorysHandle() {
        directorysHandle();
        super.optionHandle();
    }

    public void optionAndAHandle() {
        String[] operateLines = operateObject.split(System.getProperty("line.separator"));

        StringBuffer readLineBuf = new StringBuffer();
        for (int i = 0; i < operateLines.length; i++) {
            String replaceLine = operateLines[i].replaceAll("\t", "^I");
            readLineBuf.append(replaceLine + "$" + System.getProperty("line.separator"));
        }

        this.operateObject = readLineBuf.toString();
    }

    public void optionAndEHandle() {
        String[] operateLines = operateObject.split(System.getProperty("line.separator"));

        StringBuffer readLineBuf = new StringBuffer();
        for (int i = 0; i < operateLines.length; i++) {
//            String replaceLine = operateLines[i]
//                    .replaceAll(System.getProperty("line.separator"), "$");
            readLineBuf.append(operateLines[i] + "$" + System.getProperty("line.separator"));
        }

        this.operateObject = readLineBuf.toString();
    }

    public void optionAndeHandle() {
        optionAndEHandle();
    }

    public void optionAndTHandle() {
        String[] operateLines = operateObject.split(System.getProperty("line.separator"));

        StringBuffer readLineBuf = new StringBuffer();
        for (int i = 0; i < operateLines.length; i++) {
            String replaceLine = operateLines[i].replaceAll("\t", "^I");
            readLineBuf.append(replaceLine + System.getProperty("line.separator"));
        }

        this.operateObject = readLineBuf.toString();
    }

    public void optionAndtHandle() {
        optionAndTHandle();
    }

    public void optionAndnHandle() {
        String[] operateLines = operateObject.split(System.getProperty("line.separator"));

        StringBuffer readLineBuf = new StringBuffer();
        for (int i = 0; i < operateLines.length; i++) {
            String replaceLine = (i + 1) + ": " + operateLines[i];
            readLineBuf.append(replaceLine + System.getProperty("line.separator"));
        }

        this.operateObject = readLineBuf.toString();
    }

    @Override
    public void standardInPutHandle() {
        System.out.println("debugLog:Cat standardInPutHandle");
    }

    @Override
    public void optionAndStandardInPutHandle() {
        System.out.println("debugLog:Cat optionAndStandardInPutHandle");
        super.optionHandle();
    }
}
