package main.java.com.qunar.linux_cmd;

public class LinuxBashFactory {
    private final static String LINUX_BASH_CAT = "cat";
    private final static String LINUX_BASH_GREP = "grep";

    public LinuxBash getLinuxBash(String commandType) {
        if(null == commandType || "".equals(commandType)) {
            System.out.println("LinuxBashFactory getLinuxBash parameter is null");
            return null;
        }

        LinuxBash instance = null;
        switch(commandType)
        {
            case LINUX_BASH_CAT:
                instance = new Cat();
                break;
            case LINUX_BASH_GREP:
                instance = new Grep();
                break;
            default:
                break;
        }

        return instance;
    }
}
