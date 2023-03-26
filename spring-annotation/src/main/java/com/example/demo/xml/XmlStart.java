package com.example.demo.xml;

import com.example.project.po.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *ClassPathXmlApplicationContext加载ioc容器
 */
public class XmlStart {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Person person =(Person) context.getBean("person");
        System.out.println(person);
    }
}
