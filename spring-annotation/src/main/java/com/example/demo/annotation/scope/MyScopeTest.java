package com.example.demo.annotation.scope;


import com.example.demo.annotation.configuration.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyScopeTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MyScopeConfig.class);
        Object person = app.getBean("person");
        Object person1 = app.getBean("person");
        System.out.print("多个bean是否相同：");
        System.out.println(person == person1);
    }


}
