package main.java.com.qunar.linux_bash.data_struct;

public class LinuxBashDir {
    private String directoryPath = null;
    private String regexType = null;

    public LinuxBashDir(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public LinuxBashDir(String directoryPath, String regexType) {
        this.directoryPath = directoryPath;
        this.regexType = regexType;
    }
}
