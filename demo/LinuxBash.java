package main.java.com.qunar.linux_cmd;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * 用Java代码，实现诸如cat、grep、wc、sort、cut等命令组合
 * 给定一个文件目录，将目录下所有符合条件（例如txt后缀）的文件作为上述程序的输入，对每个文件输出结果（例如filename.rs）
 */
public abstract class LinuxBash {
    public enum CommonExecuteEnum implements ExecuteEnum {
        None
    }

    //LinkedHashMap(有序输出)，HashMap(无序查询)
    //采用LinkedHashMap以时间换空间，保证parseParam有序查询
    Map<ExecuteEnum, String> regexMap = new LinkedHashMap<ExecuteEnum, String>();

    public abstract void regexInit();

    public LinuxBash() {
        regexInit();
    }

    /**
     * @description:
     * 执行单命令
     */
    public abstract String execute(String cmdParam);

    /**
     * @description:
     * 执行管道多命令
     */
    public abstract String execute4PipeLine(String cmdParam, String pipeStr);

    /**
     * @description:
     * 解析命令参数的类型
     */
    public ExecuteEnum parseParam(String cmdParam) {
        for (Map.Entry<ExecuteEnum, String> regexItem : regexMap.entrySet()) {
            if(cmdParam.matches(regexItem.getValue())) {
                return regexItem.getKey();
            }
        }

        return CommonExecuteEnum.None;
    }
}
