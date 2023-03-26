package com.example.demo.annotation.imports;

import com.example.demo.annotation.compoemScan.MyScanConfig;
import com.example.demo.annotation.compoemScan.MyScanFilterConfig;
import com.example.project.service.ThirdPart3Service;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * 扫描test
 */
public class MyScanTest {

    public static void start(Class<?> clazz){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(clazz);
        String[] beanNames = app.getBeanDefinitionNames();
        String beanNameStr = Arrays.toString(beanNames).replaceAll("\\[|\\]", "")
                .replaceAll(",", "\n");
        System.out.println(beanNameStr);
        /*factoryBean -----------*/
        Object factoryBean = app.getBean("&thirdPart3Service");
        System.out.println(factoryBean);
        ThirdPart3Service thirdPart3Service = (ThirdPart3Service)app.getBean("thirdPart3Service");
        System.out.println(thirdPart3Service);
        /*-end----------------*/
    }

    /**
     * 直接@import 导入第三方类 给IoC注册Bean
     * */
    @Test
    public void MyScanConfigTest(){
        start(MyImportConfig.class);
    }

}
