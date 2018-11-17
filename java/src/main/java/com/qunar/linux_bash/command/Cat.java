package main.java.com.qunar.linux_bash.command;

import main.java.com.qunar.linux_bash.data_struct.ExecuteOption;
import main.java.com.qunar.linux_bash.data_struct.LinuxBashDir;
import main.java.com.qunar.linux_bash.data_struct.LinuxBashFile;

public class Cat {
    public enum CatExecuteOption implements ExecuteOption {
        A, b, e, E, n, s, t, T, u, v
    }

    public Cat(String... args) {}

    public Cat(CatExecuteOption option, String... args) {}

    public Cat(LinuxBashFile... files) {}

    public Cat(CatExecuteOption option, LinuxBashFile... files) {}

    public Cat(LinuxBashDir... dirPath) {}

    public Cat(CatExecuteOption option, LinuxBashDir... dirPath) {}

    private String executeString(String inputString) {

    }
}
