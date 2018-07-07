package com.qunar.linux_util;

import com.qunar.linux_base.LinuxCmdDir;
import com.qunar.linux_base.LinuxCmdFile;

import java.io.*;
import java.util.List;

public class BaseUtil {
//    public static String readFiles(List<LinuxCmdFile> linuxCmdFileList) {
//        StringBuilder readLineBuf = new StringBuilder();
//        for (LinuxCmdFile item : linuxCmdFileList) {
//            System.out.println("debugLog:File path:" + item.getFileName());
//
//            String filePath = item.getFileName();
//            File inputFile = new File(filePath);
//            if(!inputFile.exists()) {
//                System.out.println("debugLog:BaseUtil catFile file is not exist");
//                return null;
//            }
//
//            BufferedReader bufferedReader = null;
//            try {
//                bufferedReader = new BufferedReader(new FileReader(inputFile));
//                String readLine = null;
//                while((readLine = bufferedReader.readLine()) != null) {
//                    System.out.println("debugLog:BaseUtil readLines" + readLine);
//                    readLineBuf.append(readLine + System.getProperty("line.separator"));
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                return null;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return readLineBuf.toString();
//    }
//
//    public static List<LinuxCmdFile> searchDirFiles(LinuxCmdDir linuxCmdDir) {
//        File file=new File(linuxCmdDir.getFilterParam());
////        File[] tempList = file.
//        return null;
//    }
}
