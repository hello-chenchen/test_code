package com.qunar.command;

import com.qunar.linux_base.LinuxCmdDir;
import com.qunar.linux_base.LinuxCmdFile;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public abstract class LinuxCmd {
    protected String cacheOperateObject = null;
    protected boolean isOutPutLocked = false;   //对于--help，-V这些强制输出的option，直接输出，不执行其他的选项
    protected Set<CommandOption> optionSet = new TreeSet<CommandOption>();
    public List<LinuxCmdFile> linuxCmdFileList = new ArrayList<LinuxCmdFile>();
    protected List<LinuxCmdDir> linuxCmdDirList = new ArrayList<LinuxCmdDir>();

    //, noneHandle, optionAndNoneHandle
    //TODO: standardInPutHandle 标准输入，同时用于管道输入
    //TODO: 之所以每个类中都实现一次filesHandle...的枚举类型，主要考虑到netstat|ping等不需要文件作为入参的命令
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
     * TODO：绑定ExecuteType和CommandOption方法，减少execute和optionHandle方法的复杂度
     */
    public void init() {
        for(CommonExecuteType item : CommonExecuteType.values()) {
            executeMap.put(item, item.name());
        }
    }

    //TODO: 反射调用方法，实现不错。
    //FIXME: 但是有一点缺陷，就是所有的子类的内部实现方法，都必须是public的(getMethod方法限制)
    //FIXME: 这样不符合软件设计的封装性，将几乎所有的内部实现都给暴露出去了
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

    //TODO:很重要，执行ExecuteType枚举方法的反射，后期扩展命令和方法都不需要重写此方法
    public String execute() {
        String methodName = executeMap.get(executeType);

        invokeMethod(methodName);

        return this.cacheOperateObject;
    }

    //FIXME: 作为一个预留接口，判断是否存在冲突的options
    private boolean checkParameter() {
        return checkOptions();
    }

    //FIXME: 后期如果还有其他选项和参数冲突，可新增方法，放入checkParameter中
    public abstract boolean checkOptions();

    //TODO: 同上面的execite方法一样用于解耦方法的调用和分发，十分重要
    protected String optionHandle() {
        if(checkParameter()) {
            return this.cacheOperateObject;
        }
        for(CommandOption option : optionSet) {
            if(isOutPutLocked) {//TODO:预留接口，
                System.out.println("debugLog: the option is locked");
                return this.cacheOperateObject;
            }
            String optionMethodName = optionExecuteMap.get(option);

            invokeMethod(optionMethodName);
        }
        return this.cacheOperateObject;
    }

    public String execute4PipeLineHandle(String pipeInPut) {
        if(CommonExecuteType.standardInPutHandle == this.executeType
                || CommonExecuteType.optionAndStandardInPutHandle == this.executeType) {
            this.cacheOperateObject = pipeInPut;
        }

        execute();
        return this.cacheOperateObject;
    }

//    //TODO: 由于有些命令对于options有优先级顺序,所以需要重新排序
//    public abstract void reSortOptions();

    public abstract void standardInPutHandle();

    public abstract void optionAndStandardInPutHandle();
}
