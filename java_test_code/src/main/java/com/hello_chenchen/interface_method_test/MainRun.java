package main.java.com.hello_chenchen.interface_method_test;

public class MainRun {
    public static void main(String[] args) {
        InterfaceMethodTest cc = new InterfaceMethodTest() {

            @Override
            public int funcTest1() {
                return 3;
            }
        };

        System.out.println(cc.funcTest1());
    }
}
