package main.java.com.hello_chenchen;

import main.java.com.qunar.linux_cmd.LinuxBash;
import main.java.com.qunar.linux_cmd.LinuxBashHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainRun {
    private static void readInput() {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("This is linux bash >>");

        LinuxBashHandle bashInstance = new LinuxBashHandle();
        String strInput, handleResult = "";
        try{
            do {
                strInput = buffReader.readLine();
                handleResult = bashInstance.handleBash(strInput);
                System.out.println("handleResult:" + handleResult);
            }while(!"root exit".equals(strInput));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readInput();
    }
}
