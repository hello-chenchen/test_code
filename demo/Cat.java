package main.java.com.qunar.linux_cmd;

import java.io.*;

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
 *
 * Examples:
 *   cat f - g  Output f's contents, then standard input, then g's contents.
 *   cat        Copy standard input to standard output.
 *
 * GNU coreutils online help: <http://www.gnu.org/software/coreutils/>
 * Full documentation at: <http://www.gnu.org/software/coreutils/cat>
 * or available locally via: info '(coreutils) cat invocation'
 */
public class Cat extends LinuxBash {
    public enum CatExecute implements ExecuteEnum {
        //@TODO: 选项操作,待实现
        OptionAndFile,

        //@TODO: 正则表达式匹配文件夹中的文件,待实现
        RegexDirFiles,

        //已实现
        OnlyFile
    }

    @Override
    public void regexInit() {
        //@FIXME: put的顺序很重要，这决定了parseParam方法的实现是否正确。
        //正则表达式优先级范围从小到大
        regexMap.put(CommonExecuteEnum.None, "^$");

        regexMap.put(CatExecute.OptionAndFile, "^-(A|b|e|E|n|s|t|T|u|v) \\s{0,}|\\S|{1,}|\\s\\S{0,}");

        //@TODO: RegexDirFiles 的正则表达式暂不实现

        regexMap.put(CatExecute.OnlyFile, "^\\s{0,}|\\S|{1,}|\\s\\S{0,}");
    }

    @Override
    public String execute(String cmdParam) {
        ExecuteEnum executeMode = parseParam(cmdParam);
        if(CommonExecuteEnum.None == executeMode) {
            System.out.println("debugLog: Cat execute parameter is null");
            return catNone();
        }

        if(CatExecute.OptionAndFile == executeMode) {
            //@TODO: 待实现
            return "Cat execute CatExecute.OptionAndFile";
        }

        if(CatExecute.RegexDirFiles == executeMode) {
            return catRegexDirFiles(cmdParam);
        }

        if(CatExecute.OnlyFile == executeMode) {
            return catFile(cmdParam);
        }

        return "Cat instance exist BUG";
    }

    @Override
    public String execute4PipeLine(String cmdParam, String pipeStr) {
        return null;
    }

    private String catNone() {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        String strInput = "";
        try{
            do {
                System.out.println(strInput);
                strInput = buffReader.readLine();
            }while(!("exit".equals(strInput)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "exit";
    }

    private String catFile(String cmdParam) {
        System.out.println(System.getProperty("user.dir"));
        System.out.println("debugLog:File path:" + cmdParam);

        String filePath = cmdParam;
        File inputFile = new File(filePath);
        if(!inputFile.exists()) {
            System.out.println("debugLog:Cat catFile file is not exist");
            return "Cat:" + cmdParam + ": No Such file or directory";
        }

        BufferedReader bufferedReader = null;
        StringBuffer readLineBuf = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            String readLine = null;
            while((readLine = bufferedReader.readLine()) != null) {
                System.out.println(readLine);
                readLineBuf.append(readLine + System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "cat:" + cmdParam + ": No Such file or directory";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLineBuf.toString();
    }

    //@TODO: 待实现，处理文件夹正则。例如:/Dir/*.txt
    private String catRegexDirFiles(String regexParam) {
        return "Cat catRegexDirFiles method";
    }
}