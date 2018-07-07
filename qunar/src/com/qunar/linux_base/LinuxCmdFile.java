package com.qunar.linux_base;

import java.io.*;
import java.util.List;

public class LinuxCmdFile {
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileName = null;

    public LinuxCmdFile(String filename) {
        this.fileName = filename;
    }

    public String readFiles() {
        StringBuilder readLineBuf = new StringBuilder();
            System.out.println("debugLog:File path:" + fileName);

            File inputFile = new File(fileName);
            if(!inputFile.exists()) {
                System.out.println("debugLog:BaseUtil catFile file is not exist");
                return null;
            }

            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(inputFile));
                String readLine = null;
                while((readLine = bufferedReader.readLine()) != null) {
                    System.out.println("debugLog:BaseUtil readLines" + readLine);
                    readLineBuf.append(readLine + System.getProperty("line.separator"));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }

        return readLineBuf.toString();
    }
}
