package com.qunar;

import com.qunar.command.cat.Cat;
import com.qunar.command.CommandOption;
import com.qunar.command.grep.Grep;
import com.qunar.command.grep.GrepPattern;
import com.qunar.handle.CommandHandle;
import com.qunar.linux_base.LinuxCmdDir;
import com.qunar.linux_base.LinuxCmdFile;

import java.io.File;
import java.io.FileFilter;
import java.util.Set;
import java.util.TreeSet;


public class mainRun {

    public static void func() {
        LinuxCmdFile linuxCmdFile = new LinuxCmdFile("D:/demo/7/README.md");
        LinuxCmdFile linuxCmdFile1 = new LinuxCmdFile("D:/demo/7/README1.md");
        Set<CommandOption> commandOptionSet = new TreeSet<CommandOption>();
        commandOptionSet.add(Cat.CatExecuteOption.optionAndnHandle);
        commandOptionSet.add(Cat.CatExecuteOption.optionAndAHandle);
        LinuxCmdDir linuxCmdDir = new LinuxCmdDir("D:/demo/7/README.md",LinuxCmdDir.FilterType.SuffixType, ".md");
        Cat cat = new Cat(commandOptionSet, linuxCmdDir);
        Cat cat1 = new Cat(commandOptionSet, "");
        GrepPattern grepPattern = new GrepPattern("chenchen");
        Grep grep = new Grep(grepPattern, "");
        CommandHandle commandHandle = new CommandHandle(cat);
        System.out.println(commandHandle.execute());
    }

    public static void func1() {
        File file = new File("D:/git/test_code/demo");

        for(File item : file.listFiles()) {
            System.out.println(item.getAbsolutePath());
        }

        String cc= "asdf*ccc";
        System.out.println(cc.replaceAll("\\*", ".*"));
        System.out.println(cc.matches("a.*c"));
    }

    public static void main(String[] args) {
        func();
    }
}
