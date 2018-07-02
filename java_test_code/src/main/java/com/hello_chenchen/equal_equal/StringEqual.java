package main.java.com.hello_chenchen.equal_equal;

public class StringEqual {

    public static void func1() {
        String s1 = "hellO_chenchen";
        String s2 = "hellO_chenchen";
        s2 = s2.toLowerCase();
        System.out.println(s1);
    }

    private void InterEqual() {
        Integer intDemo = 2;
        intDemo.equals(3);
        if(intDemo == new Integer(1)) {
        }
    }

    private void foo() {
        int  b[][]={{1}, {2,2}, {2,2,2}};
        int sum=0;
        for(int i=0;i<b.length;i++) {
            for(int j=0;j<b[i].length;j++) {
                sum+=b[i][j];
            }
        }
    }

    public static int func() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
