package com.qunar.linux_util;

import com.qunar.linux_base.LinuxCmdDir;
import com.qunar.linux_base.LinuxCmdFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseUtil {

    public static long getStrByteLength(String inPut) {
        if(inPut == null) {
            System.out.println("errorLog:BaseUtil getStrByteLength input is null");
            return 0;
        }

        return inPut.getBytes().length;
    }

    public static int getStrLineNumber(String inPut) {
        if(inPut == null) {
            System.out.println("errorLog:BaseUtil getStrLineNumber input is null");
            return 0;
        }

        String[] inPutArray = inPut.split(System.getProperty("line.separator"));

        return inPutArray.length;
    }

    public static int getStrWordCount(String inPut) {
        if(inPut == null) {
            System.out.println("errorLog:BaseUtil getStrWordCount input is null");
            return 0;
        }

        String[] inPutArray = inPut.split(System.getProperty("line.separator"));

        int wordCount = 0;
        for (int i = 0; i < inPutArray.length; i++) {
            String[] wordArray = inPutArray[i].split(" ");
            wordCount += wordArray.length;
        }

        return wordCount;
    }

    public static String sortLines(String inPut) {
        if(inPut == null) {
            System.out.println("errorLog:BaseUtil getStrWordCount input is null");
            return "";
        }

        String[] inPutArray = inPut.split(System.getProperty("line.separator"));
        List<String> stringList = new ArrayList<String>();
        for (int i = 0; i < inPutArray.length; i++) {
            stringList.add(inPutArray[i]);
        }

        Collections.sort(stringList);

        StringBuilder result = new StringBuilder();
        for (String item : stringList) {
            result.append(item + System.getProperty("line.separator"));
        }

        return result.toString();
    }
}
