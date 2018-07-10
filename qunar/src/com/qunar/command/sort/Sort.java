package com.qunar.command.sort;

import com.qunar.command.ExecuteType;
import com.qunar.command.LinuxCmd;
import com.qunar.linux_base.LinuxCmdDir;
import com.qunar.linux_base.LinuxCmdFile;
import com.qunar.linux_util.BaseUtil;

/**
 * @description:
 * Usage: sort [OPTION]... [FILE]...
 *   or:  sort [OPTION]... --files0-from=F
 * Write sorted concatenation of all FILE(s) to standard output.
 *
 * With no FILE, or when FILE is -, read standard input.
 *
 * Mandatory arguments to long options are mandatory for short options too.
 * Ordering options:
 *
 *   -b, --ignore-leading-blanks  ignore leading blanks
 *   -d, --dictionary-order      consider only blanks and alphanumeric characters
 *   -f, --ignore-case           fold lower case to upper case characters
 *   -g, --general-numeric-sort  compare according to general numerical value
 *   -i, --ignore-nonprinting    consider only printable characters
 *   -M, --month-sort            compare (unknown) < 'JAN' < ... < 'DEC'
 *   -h, --human-numeric-sort    compare human readable numbers (e.g., 2K 1G)
 *   -n, --numeric-sort          compare according to string numerical value
 *   -R, --random-sort           shuffle, but group identical keys.  See shuf(1)
 *       --random-source=FILE    get random bytes from FILE
 *   -r, --reverse               reverse the result of comparisons
 *       --sort=WORD             sort according to WORD:
 *                                 general-numeric -g, human-numeric -h, month -M,
 *                                 numeric -n, random -R, version -V
 *   -V, --version-sort          natural sort of (version) numbers within text
 *
 * Other options:
 *
 *       --batch-size=NMERGE   merge at most NMERGE inputs at once;
 *                             for more use temp files
 *   -c, --check, --check=diagnose-first  check for sorted input; do not sort
 *   -C, --check=quiet, --check=silent  like -c, but do not report first bad line
 *       --compress-program=PROG  compress temporaries with PROG;
 *                               decompress them with PROG -d
 *       --debug               annotate the part of the line used to sort,
 *                               and warn about questionable usage to stderr
 *       --files0-from=F       read input from the files specified by
 *                             NUL-terminated names in file F;
 *                             If F is - then read names from standard input
 *   -k, --key=KEYDEF          sort via a key; KEYDEF gives location and type
 *   -m, --merge               merge already sorted files; do not sort
 *   -o, --output=FILE         write result to FILE instead of standard output
 *   -s, --stable              stabilize sort by disabling last-resort comparison
 *   -S, --buffer-size=SIZE    use SIZE for main memory buffer
 *   -t, --field-separator=SEP  use SEP instead of non-blank to blank transition
 *   -T, --temporary-directory=DIR  use DIR for temporaries, not $TMPDIR or /tmp;
 *                               multiple options specify multiple directories
 *       --parallel=N          change the number of sorts run concurrently to N
 *   -u, --unique              with -c, check for strict ordering;
 *                               without -c, output only the first of an equal run
 *   -z, --zero-terminated     line delimiter is NUL, not newline
 *       --help     display this help and exit
 *       --version  output version information and exit
 */
public class Sort extends LinuxCmd {
    //TODO:Options enum

    //TODO:optionAndFilesHandle,optionAndDirectorysHandle
    public enum SortExecuteType implements ExecuteType {
        filesHandle, directorysHandle;
    }

    public Sort() {}

    public Sort(String standardInPut) {
        this.executeType = CommonExecuteType.standardInPutHandle;
        this.cacheOperateObject = standardInPut;
    }

//    public Sort(Set<CommandOption> options, String standardInPut) {
//        this.executeType = CommonExecuteType.optionAndStandardInPutHandle;
//        this.cacheOperateObject = standardInPut;
//        this.optionSet = options;
//    }

    public Sort(LinuxCmdFile... files) {
        init();
        this.executeType = SortExecuteType.filesHandle;
        for (LinuxCmdFile item : files) {
            this.linuxCmdFileList.add(item);
        }
    }

//    public Sort(Set<CommandOption> options, LinuxCmdFile... files) {
//        init();
//        this.executeType = CatExecuteType.optionAndFilesHandle;
//        this.optionSet = options;
//        for (LinuxCmdFile item : files) {
//            linuxCmdFileList.add(item);
//        }
//    }

    public Sort(LinuxCmdDir... dirPath) {
        init();
        this.executeType = SortExecuteType.directorysHandle;
        for (LinuxCmdDir item : dirPath) {
            linuxCmdDirList.add(item);
        }
    }

//    public Sort(Set<CommandOption> options, LinuxCmdDir... dirPath) {
//        init();
//        this.executeType = CatExecuteType.optionAndDirectorysHandle;
//        this.optionSet = options;
//        for (LinuxCmdDir item : dirPath) {
//            linuxCmdDirList.add(item);
//        }
//    }

    public void init() {
        super.init();
        for(SortExecuteType item : SortExecuteType.values()) {
            executeMap.put(item, item.name());
        }

        //TODO:Options
    }

    public void filesHandle() {
        //TODO:
        if(this.linuxCmdFileList.size() <= 0) {
            System.out.println("debugLog:Cat No Such Files");
            return;
        }

        StringBuilder result = new StringBuilder();
        for (LinuxCmdFile item : linuxCmdFileList) {
            result.append(item.readLines());
        }

        this.cacheOperateObject = BaseUtil.sortLines(result.toString());
    }

    //TODO: optionAndFilesHandle

    public void directorysHandle() {
        //TODO:
    }

    //TODO: optionAndDirectorysHandle


    @Override
    public void standardInPutHandle() {
        //TODO:
        String result = cacheOperateObject;

        this.cacheOperateObject = BaseUtil.sortLines(result);
    }

    @Override
    public void optionAndStandardInPutHandle() {
        //TODO:待实现
    }

    @Override
    public boolean checkOptions() {
        return false;
    }

    //TODO: Options
}
