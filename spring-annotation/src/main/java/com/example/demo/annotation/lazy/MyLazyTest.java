package com.example.demo.annotation.lazy;

import com.example.demo.annotation.configuration.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2023/3/26
 * Time:17:55
 */
public class MyLazyTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MyLazyConfig.class);
        System.out.println("init load finish!!");
        /*调用对象功能时才创建*/
        app.getBean("person");
    }
}
