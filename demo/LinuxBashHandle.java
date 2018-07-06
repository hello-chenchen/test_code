package main.java.com.qunar.linux_cmd;

public class LinuxBashHandle {
    private String handleCommand(String commandLine) {
        String[] commandItem = commandLine.split(" ");

        LinuxBashFactory bashFactory = new LinuxBashFactory();
        LinuxBash bashInstance = bashFactory.getLinuxBash(commandItem[0]);
        if(null == bashInstance) {
            System.out.println("debugLog: LinuxBashHandle handleCommand bashInstance is null");
            return commandLine + ": command not found";
        }

        return bashInstance.execute(commandLine.substring(commandItem[0].length()).trim());
    }

    private String handlePipeCommand(String command, String strInPut) {
        String[] commandItem = command.split(" ");

        LinuxBashFactory bashFactory = new LinuxBashFactory();
        LinuxBash bashInstance = bashFactory.getLinuxBash(commandItem[0]);
        if(null == bashInstance) {
            System.out.println("debugLog: LinuxBashHandle handlePipeCommand bashInstance is null");
            return null;
        }

        return bashInstance.execute4PipeLine(command.substring(commandItem[0].length()), strInPut);
    }

    private String handlePipeLine(String commandLine) {
        String[] pipeCommand = commandLine.split("\\|");

        String pipeResult = handleCommand(pipeCommand[0]);

        for(int i = 1; i < pipeCommand.length; i++) {
            pipeResult = handlePipeCommand(pipeCommand[i], pipeResult);
        }

        return pipeResult;
    }

    public String handleBash(String commandLine) {
        if(null == commandLine || "".equals(commandLine)) {
            System.out.println("debugLog: LinuxBashHandle handleBash parameter is null");
            return "No input, please input:";
        }

        return handlePipeLine(commandLine);
    }
}
