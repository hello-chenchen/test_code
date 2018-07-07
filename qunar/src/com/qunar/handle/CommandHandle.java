package com.qunar.handle;

import com.qunar.command.LinuxCmd;

import java.util.ArrayList;
import java.util.List;

public class CommandHandle {
    private List<LinuxCmd> linuxCmdList = new ArrayList<LinuxCmd>();

    public CommandHandle(LinuxCmd... linuxCmds) {
        for (LinuxCmd linuxCmd : linuxCmds) {
            linuxCmdList.add(linuxCmd);
        }
    }

    private String handleCommand(LinuxCmd command) {
        return command.execute();
    }

    private String handlePipeCommand(LinuxCmd command, String strInPut) {
        return command.execute4PipeLineHandle(strInPut);
    }

    public String execute() {
        if(linuxCmdList.size() <= 0) {
            System.out.println("debugLog: Commandhandle execute is null");
            return "LinuxCmd instance is null";
        }

        String pipeResult = handleCommand(linuxCmdList.get(0));
        for (int i = 1; i < linuxCmdList.size(); i++) {
            pipeResult = handlePipeCommand(linuxCmdList.get(i), pipeResult);
        }

        return pipeResult;
    }
}
