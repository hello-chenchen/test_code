package com.qunar.command;

import com.qunar.linux_base.LinuxCmdDir;
import com.qunar.linux_base.LinuxCmdFile;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public abstract class LinuxCmd {
    protected String operateObject = null;
    protected boolean isOutPutLocked = false;   //对于--help，-V这些强制输出的option，直接输出，不执行其他的选项
    protected Set<CommandOption> optionList = new TreeSet<CommandOption>();
    public List<LinuxCmdFile> linuxCmdFileList = new ArrayList<LinuxCmdFile>();
    protected List<LinuxCmdDir> linuxCmdDirList = new ArrayList<LinuxCmdDir>();

    //, noneHandle, optionAndNoneHandle
    public enum CommonExecuteType implements ExecuteType {
        standardInPutHandle, optionAndStandardInPutHandle;
    }
    //executeType默认值是标准输入
    protected ExecuteType executeType = CommonExecuteType.standardInPutHandle;
    protected Map<ExecuteType, String> executeMap = new HashMap<ExecuteType, String>();
    protected Map<CommandOption, String> optionExecuteMap = new HashMap<CommandOption, String>();

    public LinuxCmd() {
        init();
    }

    /**
     * @description:
     * 绑定ExecuteType和方法，减少execute方法的复杂度
     */
    public void init() {
        for(CommonExecuteType item : CommonExecuteType.values()) {
            executeMap.put(item, item.name());
        }
    }

    private Object invokeMethod(String methodName) {
        try {
            Method method = this.getClass().getMethod(methodName);
            method.invoke(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String execute() {
        String methodName = executeMap.get(executeType);

        invokeMethod(methodName);

        return this.operateObject;
    }

    protected String optionHandle() {
        for(CommandOption option : optionList) {
            if(isOutPutLocked) {
                System.out.println("debugLog: the option is locked");
                return this.operateObject;
            }
            String optionMethodName = optionExecuteMap.get(option);

            invokeMethod(optionMethodName);
        }
        return this.operateObject;
    }

    public String execute4PipeLineHandle(String pipeInPut) {
        if(CommonExecuteType.standardInPutHandle == this.executeType
                || CommonExecuteType.optionAndStandardInPutHandle == this.executeType) {
            this.operateObject = pipeInPut;
        }

        execute();
        return this.operateObject;
    }

    protected abstract void standardInPutHandle();

    protected abstract void optionAndStandardInPutHandle();
}
