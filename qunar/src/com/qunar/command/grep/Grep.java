package com.qunar.command.grep;

import com.qunar.command.CommandOption;
import com.qunar.command.ExecuteType;
import com.qunar.command.LinuxCmd;
import com.qunar.linux_base.LinuxCmdDir;
import com.qunar.linux_base.LinuxCmdFile;

import java.util.Set;

/**
 * @description:
 * Usage: grep [OPTION]... PATTERN [FILE]...
 * Search for PATTERN in each FILE or standard input.
 * PATTERN is, by default, a basic regular expression (BRE).
 * Example: grep -i 'hello world' menu.h main.c
 *
 * Regexp selection and interpretation:
 *   -E, --extended-regexp     PATTERN is an extended regular expression (ERE)
 *   -F, --fixed-strings       PATTERN is a set of newline-separated strings
 *   -G, --basic-regexp        PATTERN is a basic regular expression (BRE)
 *   -P, --perl-regexp         PATTERN is a Perl regular expression
 *   -e, --regexp=PATTERN      use PATTERN for matching
 *   -f, --file=FILE           obtain PATTERN from FILE
 *   -i, --ignore-case         ignore case distinctions
 *   -w, --word-regexp         force PATTERN to match only whole words
 *   -x, --line-regexp         force PATTERN to match only whole lines
 *   -z, --null-data           a data line ends in 0 byte, not newline
 *
 * Miscellaneous:
 *   -s, --no-messages         suppress error messages
 *   -v, --invert-match        select non-matching lines
 *   -V, --version             display version information and exit
 *       --help                display this help text and exit
 *
 * Output control:
 *   -m, --max-count=NUM       stop after NUM matches
 *   -b, --byte-offset         print the byte offset with output lines
 *   -n, --line-number         print line number with output lines
 *       --line-buffered       flush output on every line
 *   -H, --with-filename       print the file name for each match
 *   -h, --no-filename         suppress the file name prefix on output
 *       --label=LABEL         use LABEL as the standard input file name prefix
 *   -o, --only-matching       show only the part of a line matching PATTERN
 *   -q, --quiet, --silent     suppress all normal output
 *       --binary-files=TYPE   assume that binary files are TYPE;
 *                             TYPE is 'binary', 'text', or 'without-match'
 *   -a, --text                equivalent to --binary-files=text
 *   -I                        equivalent to --binary-files=without-match
 *   -d, --directories=ACTION  how to handle directories;
 *                             ACTION is 'read', 'recurse', or 'skip'
 *   -D, --devices=ACTION      how to handle devices, FIFOs and sockets;
 *                             ACTION is 'read' or 'skip'
 *   -r, --recursive           like --directories=recurse
 *   -R, --dereference-recursive  likewise, but follow all symlinks
 *       --include=FILE_PATTERN  search only files that match FILE_PATTERN
 *       --exclude=FILE_PATTERN  skip files and directories matching FILE_PATTERN
 *       --exclude-from=FILE   skip files matching any file pattern from FILE
 *       --exclude-dir=PATTERN  directories that match PATTERN will be skipped.
 *   -L, --files-without-match  print only names of FILEs containing no match
 *   -l, --files-with-matches  print only names of FILEs containing matches
 *   -c, --count               print only a count of matching lines per FILE
 *   -T, --initial-tab         make tabs line up (if needed)
 *   -Z, --null                print 0 byte after FILE name
 *
 * Context control:
 *   -B, --before-context=NUM  print NUM lines of leading context
 *   -A, --after-context=NUM   print NUM lines of trailing context
 *   -C, --context=NUM         print NUM lines of output context
 *   -NUM                      same as --context=NUM
 *       --color[=WHEN],
 *       --colour[=WHEN]       use markers to highlight the matching strings;
 *                             WHEN is 'always', 'never', or 'auto'
 *   -U, --binary              do not strip CR characters at EOL (MSDOS/Windows)
 *   -u, --unix-byte-offsets   report offsets as if CRs were not there
 *                             (MSDOS/Windows)
 */
public class Grep extends LinuxCmd {

    private GrepPattern grepPattern = null;
    //TODO：功能太多,仅实现-n
    //TODO: 未实现的功能很多，待扩展
    //FIXME: optionHandle调用方法的时候,CommandOption的顺序排序
    public enum GrepExecuteOption implements CommandOption {
        optionAndrHandle, optionAndRHandle, optionAndnHandle;
    }

    public enum GrepExecuteType implements ExecuteType {
        filesHandle, optionAndFilesHandle,
        directorysHandle, optionAndDirectorysHandle;
    }

    //FIXME:为了实现execute和optionHandle的反射必须实例化无参构造函数
    public Grep() {}

    public Grep(GrepPattern grepPattern, String standardInPut) {
        init();
        this.executeType = CommonExecuteType.standardInPutHandle;
        this.grepPattern = grepPattern;
        this.cacheOperateObject = standardInPut;
    }

    public Grep(GrepPattern grepPattern, Set<CommandOption> options, String standardInPut) {
        init();
        this.executeType = CommonExecuteType.optionAndStandardInPutHandle;
        this.grepPattern = grepPattern;
        this.cacheOperateObject = standardInPut;
        this.optionSet = options;
    }

    public Grep(GrepPattern grepPattern, LinuxCmdFile... files) {
        init();
        this.executeType = GrepExecuteType.filesHandle;
        this.grepPattern = grepPattern;
        for (LinuxCmdFile item : files) {
            linuxCmdFileList.add(item);
        }
    }

    public Grep(GrepPattern grepPattern, Set<CommandOption> options, LinuxCmdFile... files) {
        init();
        this.executeType = GrepExecuteType.optionAndFilesHandle;
        this.grepPattern = grepPattern;
        this.optionSet = options;
        for (LinuxCmdFile item : files) {
            linuxCmdFileList.add(item);
        }
    }

    public Grep(GrepPattern grepPattern, LinuxCmdDir... dirPath) {
        init();
        this.executeType = GrepExecuteType.directorysHandle;
        this.grepPattern = grepPattern;
        for (LinuxCmdDir item : dirPath) {
            linuxCmdDirList.add(item);
        }
    }

    public Grep(GrepPattern grepPattern, Set<CommandOption> options, LinuxCmdDir... dirPath) {
        init();
        this.grepPattern = grepPattern;
        this.executeType = GrepExecuteType.optionAndDirectorysHandle;
        this.optionSet = options;
        for (LinuxCmdDir item : dirPath) {
            linuxCmdDirList.add(item);
        }
    }

    @Override
    public void init() {
        super.init();
        for(GrepExecuteType item : GrepExecuteType.values()) {
            executeMap.put(item, item.name());
        }

        for(GrepExecuteOption item : GrepExecuteOption.values()) {
            optionExecuteMap.put(item, item.name());
        }
    }

    private String grepHandle(String lines) {
        String[] operateLines = lines.split(System.getProperty("line.separator"));

        StringBuffer readLineBuf = new StringBuffer();
        for (int i = 0; i < operateLines.length; i++) {
            if(operateLines[i].matches(grepPattern.getFilterParam())
                    || operateLines[i].contains(grepPattern.getFilterParam())) {
                readLineBuf.append(operateLines[i] + System.getProperty("line.separator"));
            }
        }

        return readLineBuf.toString();
    }

    public void filesHandle() {
        if(linuxCmdFileList.size() <= 0) {
            System.out.println("debugLog:Grep No Such Files");
            return;
        }

        StringBuilder result = new StringBuilder();
        for (LinuxCmdFile item : linuxCmdFileList) {
            result .append(item.readLines());
        }

        this.cacheOperateObject = grepHandle(result.toString());
    }

    public void optionAndFilesHandle() {
        filesHandle();
        super.optionHandle();
    }

    public void directorysHandle() {
        StringBuilder result = new StringBuilder();
        for (LinuxCmdDir linuxCmdDirItem : linuxCmdDirList) {
            for (LinuxCmdFile linuxCmdFileItem : linuxCmdDirItem.listDirFiles()) {
                result.append(linuxCmdFileItem.readLines());
            }
        }

        this.cacheOperateObject = grepHandle(result.toString());
    }

    public void optionAndDirectorysHandle() {
        directorysHandle();
        super.optionHandle();
    }

    public void optionAndnHandle() {
        String[] operateLines = cacheOperateObject.split(System.getProperty("line.separator"));

        StringBuffer readLineBuf = new StringBuffer();
        for (int i = 0; i < operateLines.length; i++) {
            String replaceLine = i + ": " + operateLines[i];
            readLineBuf.append(replaceLine + System.getProperty("line.separator"));
        }

        this.cacheOperateObject = readLineBuf.toString();
    }

    //FIXME: 由于递归查找的特殊性，所以优先选择递归文件夹，如果文件夹无数据则查找缓存数据
    public void optionAndrHandle() {
        String temp = "";
        if(linuxCmdDirList.size() > 0) {
            StringBuilder result = new StringBuilder();
            for (LinuxCmdDir linuxCmdDirItem : linuxCmdDirList) {
                for (LinuxCmdFile linuxCmdFileItem : linuxCmdDirItem.listRecursionDirFiles()) {
                    result.append(linuxCmdFileItem.readLines());
                }
            }
            temp = result.toString();
        } else {
            temp = cacheOperateObject;
        }

        this.cacheOperateObject = grepHandle(temp);
    }

    public void optionAndRHandle() {
        optionAndrHandle();
    }

    @Override
    public void standardInPutHandle() {
        String[] operateLines = cacheOperateObject.split(System.getProperty("line.separator"));

        StringBuffer readLineBuf = new StringBuffer();
        for (int i = 0; i < operateLines.length; i++) {
            if(operateLines[i].matches(grepPattern.getFilterParam())
                    || operateLines[i].contains(grepPattern.getFilterParam())) {
                readLineBuf.append(operateLines[i] + System.getProperty("line.separator"));
            }
        }

        this.cacheOperateObject = readLineBuf.toString();
    }

    @Override
    public void optionAndStandardInPutHandle() {
        standardInPutHandle();
        super.optionHandle();
    }

    @Override
    public boolean checkOptions() {//暂无冲突项
        return false;
    }
}
