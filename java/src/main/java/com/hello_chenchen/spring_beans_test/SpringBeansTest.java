package main.java.com.hello_chenchen.spring_beans_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class SpringBeansTest {

    @Autowired
    public SpringBeansTest(ParamValue1 param2) {
        this.param2 = param2;
        System.out.println(this.toString());
    }

    private String param1 = "parma1";

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    @Autowired
    private ParamValue1 param2;

    public ParamValue1 getParam2() {
        return param2;
    }

    public void setParam2(ParamValue1 param2) {
        this.param2 = param2;
    }
}
