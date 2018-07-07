package com.qunar;

import com.qunar.command.Cat;
import com.qunar.command.CommandOption;
import com.qunar.command.grep.Grep;
import com.qunar.handle.CommandHandle;
import com.qunar.linux_base.LinuxCmdFile;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;


public class mainRun {

    public static void func() {
        LinuxCmdFile linuxCmdFile = new LinuxCmdFile("D:/demo/1/README.md");
        Set<CommandOption> commandOptionSet = new TreeSet<CommandOption>();
        commandOptionSet.add(Cat.CatExecuteOption.optionAndnHandle);
        commandOptionSet.add(Cat.CatExecuteOption.optionAndEHandle);
        Cat cat = new Cat(commandOptionSet, linuxCmdFile);
//        Grep grep = new Grep()
        CommandHandle commandHandle = new CommandHandle(cat);
        System.out.println(commandHandle.execute());
    }

    public static String func1() {
        File inputFile = new File("D:/demo/1/README.md");

        BufferedReader bufferedReader = null;
        StringBuffer readLineBuf = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            String readLine = null;
            while((readLine = bufferedReader.readLine()) != null) {
                System.out.println(readLine);
                readLineBuf.append(readLine + System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLineBuf.toString();
    }

    public static void main(String[] args) {
        func();
    }
}
