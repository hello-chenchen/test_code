package com.qunar.command.wc;

import com.qunar.command.CommandOption;
import com.qunar.command.ExecuteType;
import com.qunar.command.LinuxCmd;
import com.qunar.linux_base.LinuxCmdDir;
import com.qunar.linux_base.LinuxCmdFile;
import com.qunar.linux_util.BaseUtil;

import java.util.Set;

/**
 * @description:
 * Usage: wc [OPTION]... [FILE]...
 *   or:  wc [OPTION]... --files0-from=F
 * Print newline, word, and byte counts for each FILE, and a total line if
 * more than one FILE is specified.  A word is a non-zero-length sequence of
 * characters delimited by white space.
 *
 * With no FILE, or when FILE is -, read standard input.
 *
 * The options below may be used to select which counts are printed, always in
 * the following order: newline, word, character, byte, maximum line length.
 *   -c, --bytes            print the byte counts
 *   -m, --chars            print the character counts
 *   -l, --lines            print the newline counts
 *       --files0-from=F    read input from the files specified by
 *                            NUL-terminated names in file F;
 *                            If F is - then read names from standard input
 *   -L, --max-line-length  print the maximum display width
 *   -w, --words            print the word counts
 *       --help     display this help and exit
 *       --version  output version information and exit
 */
public class Wc extends LinuxCmd {

//    public enum WcExecuteOption implements CommandOption {
//        optionAndcHandle, optionAndmHandle, optionAndlHandle,
//        optionAndLandle, optionAndwHandle;
//    }

    //TODO:optionAndFilesHandle, optionAndDirectorysHandle
    //TODO:由于组合选项输出未想好如何实现，暂不实现，待补充
    public enum WcExecuteType implements ExecuteType {
        filesHandle, directorysHandle;
    }

    public Wc() {}

    public Wc(String standardInPut) {
        this.executeType = CommonExecuteType.standardInPutHandle;
        this.cacheOperateObject = standardInPut;
    }

//    public Wc(Set<CommandOption> options, String standardInPut) {
//        this.executeType = CommonExecuteType.optionAndStandardInPutHandle;
//        this.cacheOperateObject = standardInPut;
//        this.optionSet = options;
//    }

    public Wc(LinuxCmdFile... files) {
        init();
        this.executeType = WcExecuteType.filesHandle;
        for (LinuxCmdFile item : files) {
            this.linuxCmdFileList.add(item);
        }
    }

//    public Wc(Set<CommandOption> options, LinuxCmdFile... files) {
//        init();
//        this.executeType = WcExecuteType.optionAndFilesHandle;
//        this.optionSet = options;
//        for (LinuxCmdFile item : files) {
//            linuxCmdFileList.add(item);
//        }
//    }

    public Wc(LinuxCmdDir... dirPath) {
        init();
        this.executeType = WcExecuteType.directorysHandle;
        for (LinuxCmdDir item : dirPath) {
            linuxCmdDirList.add(item);
        }
    }

//    public Wc(Set<CommandOption> options, LinuxCmdDir... dirPath) {
//        init();
//        this.executeType = WcExecuteType.optionAndDirectorysHandle;
//        this.optionSet = options;
//        for (LinuxCmdDir item : dirPath) {
//            linuxCmdDirList.add(item);
//        }
//    }

    @Override
    public void init() {
        super.init();
        for(WcExecuteType item : WcExecuteType.values()) {
            executeMap.put(item, item.name());
        }

//        for(WcExecuteOption item : WcExecuteOption.values()) {
//            optionExecuteMap.put(item, item.name());
//        }
    }

//    @Override
//    public String execute() {
//        if(WcExecuteType.filesHandle == executeType ||
//                WcExecuteType.directorysHandle == executeType) {
//            return super.execute();
//        }
//    }

    public void filesHandle() {
        //TODO:
        if(this.linuxCmdFileList.size() <= 0) {
            System.out.println("debugLog:Cat No Such Files");
            return;
        }

        StringBuilder result = new StringBuilder();
        for (LinuxCmdFile item : linuxCmdFileList) {
            result.append(item.getLineNumber() + " " + item.getWordCount() + " "
                    + item.getLength() + " " + item.getFileName() + System.getProperty("line.separator"));
        }

        this.cacheOperateObject = result.toString();
    }

//    public void optionAndFilesHandle() {
//        //TODO:
//        super.optionHandle();
//    }

    public void directorysHandle() {
        String result = "";
        for (LinuxCmdDir linuxCmdDirItem : linuxCmdDirList) {
            for (LinuxCmdFile linuxCmdFileItem : linuxCmdDirItem.listDirFiles()) {
                result += linuxCmdFileItem.getLineNumber() + " " + linuxCmdFileItem.getWordCount() + " "
                        + linuxCmdFileItem.getLength() + " " + linuxCmdFileItem.getFileName() + System.getProperty("line.separator");
            }
        }

        this.cacheOperateObject = result;
    }

//    public void optionAndDirectorysHandle() {
//        //TODO:
//    }

    @Override
    public void standardInPutHandle() {
        //TODO:
        String result = cacheOperateObject;
        this.cacheOperateObject = BaseUtil.getStrLineNumber(result) + " "
                + BaseUtil.getStrWordCount(result) + " " + BaseUtil.getStrByteLength(result);
    }

    @Override
    public void optionAndStandardInPutHandle() {
        //TODO:未想好如何实现wc命令的options组合,待补充实现
//        super.optionHandle();
    }

    @Override
    public boolean checkOptions() {//暂无冲突项
        return false;
    }

//    public void optionAndcHandle() {
//        //TODO:
//    }
//
//    public void optionAndmHandle() {
//        optionAndcHandle();
//    }
//
//    public void optionAndlHandle() {
//        //TODO:
//    }
//
//    public void optionAndLandle() {
//        //TODO:
//    }
//
//    public void optionAndwHandle() {
//        //TODO:
//    }
}
