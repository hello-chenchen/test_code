package com.qunar;

import com.qunar.command.cat.Cat;
import com.qunar.command.CommandOption;
import com.qunar.command.grep.Grep;
import com.qunar.command.grep.GrepPattern;
import com.qunar.command.sort.Sort;
import com.qunar.command.wc.Wc;
import com.qunar.handle.CommandHandle;
import com.qunar.linux_base.LinuxCmdDir;
import com.qunar.linux_base.LinuxCmdFile;

import java.io.*;
import java.util.*;


public class mainRun {

    public static void func() {
        LinuxCmdFile linuxCmdFile = new LinuxCmdFile("D:/demo/7/README.md");
        LinuxCmdFile linuxCmdFile1 = new LinuxCmdFile("D:/demo/7/README1.md");
        LinuxCmdDir linuxCmdDir = new LinuxCmdDir("D:/demo/7",LinuxCmdDir.FilterType.SuffixType, ".md");

        Set<CommandOption> commandOptionSet = new TreeSet<CommandOption>();
        commandOptionSet.add(Cat.CatExecuteOption.optionAndnHandle);
        commandOptionSet.add(Cat.CatExecuteOption.optionAndAHandle);

        Cat cat = new Cat(commandOptionSet, linuxCmdFile);
        Cat cat1 = new Cat(commandOptionSet, "");

        Set<CommandOption> commandOptionSet1 = new TreeSet<CommandOption>();
        commandOptionSet1.add(Grep.GrepExecuteOption.optionAndnHandle);
        commandOptionSet1.add(Grep.GrepExecuteOption.optionAndRHandle);
        GrepPattern grepPattern = new GrepPattern("c");
        Grep grep = new Grep(grepPattern, commandOptionSet1, "");

        Wc wc = new Wc(linuxCmdDir);
        Sort sort = new Sort(linuxCmdFile);

        CommandHandle commandHandle = new CommandHandle(cat, cat1, sort);
        System.out.println(commandHandle.execute());
    }
    public static void main(String[] args) {
        func();
    }
}
