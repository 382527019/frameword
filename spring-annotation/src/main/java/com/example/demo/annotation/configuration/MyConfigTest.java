package com.example.demo.annotation.configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2023/3/26
 * Time:15:38
 */
public class MyConfigTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        /*1.类名首字母小写作为BeanName*/
        Object person = app.getBean("person");
        System.out.println(person);

        /*2.方法名作为BeanName*/
        Object person1 = app.getBean("person1");
        System.out.println(person1);

        /*3.优先取注解value作为BeanName*/
        Object beanName = app.getBean("beanName");
        System.out.println(beanName);

    }
}
