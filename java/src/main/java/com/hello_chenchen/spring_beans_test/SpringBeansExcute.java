package main.java.com.hello_chenchen.spring_beans_test;

import com.sun.javaws.security.Resource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringBeansExcute {
    public void func() {
//        ClassPathResource param4 = new ClassPathResource("spring_beans_test.xml");
//        BeanFactory param1 = new XmlBeanFactory(param4);
        ApplicationContext param1 = new ClassPathXmlApplicationContext("spring_beans_test.xml");
        SpringBeansTest param2 = (SpringBeansTest) param1.getBean("springBeansTest");

        System.out.println(param2.getParam1());
        param2.setParam1("param2");

        SpringBeansTest param3 = (SpringBeansTest) param1.getBean("springBeansTest");
        System.out.println(param3.getParam1());
    }

}
