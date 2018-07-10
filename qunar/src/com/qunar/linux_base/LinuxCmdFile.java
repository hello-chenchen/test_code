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

    public String readLines() {
        StringBuilder readLineBuf = new StringBuilder();
            System.out.println("debugLog:File path:" + fileName);

            File inputFile = new File(fileName);
            if(!inputFile.exists()) {
                System.out.println("debugLog:BaseUtil catFile file is not exist");
                return "";
            }

            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
                String readLine = "";
                while((readLine = bufferedReader.readLine()) != null) {
                    System.out.println("debugLog:BaseUtil readLines" + readLine);
                    readLineBuf.append(readLine + System.getProperty("line.separator"));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return readLineBuf.toString();
    }

    public long getLength() {
        File inputFile = new File(fileName);
        if(!inputFile.exists()) {
            System.out.println("debugLog:BaseUtil catFile file is not exist");
            return 0;
        }

        return inputFile.length();
    }

    public int getLineNumber() {
        int lineNumber = 0;
        File inputFile = new File(fileName);
        if(!inputFile.exists()) {
            System.out.println("debugLog:BaseUtil catFile file is not exist");
            return 0;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

            String readLine = null;
            while((readLine = bufferedReader.readLine()) != null) {
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineNumber;
    }

    public int getWordCount() {
        int wordCount = 0;
        File inputFile = new File(fileName);
        if(!inputFile.exists()) {
            System.out.println("debugLog:BaseUtil catFile file is not exist");
            return 0;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

            String readLine = null;
            while((readLine = bufferedReader.readLine()) != null) {
                String[] readLineList = readLine.split(" ");
                wordCount += readLineList.length;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordCount;
    }
}
