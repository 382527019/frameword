package com.example.demo.annotation.conditional;

import com.example.demo.annotation.configuration.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2023/3/26
 * Time:15:38
 */
public class MyConditionalTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MyConditionalConfig.class);


    }
}
