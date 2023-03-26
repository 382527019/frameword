package com.example.demo.annotation.compoemScan;

import com.example.demo.annotation.configuration.MyConfig;
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
    }

    /**
     * 1.@ComponentScan(value = "com.example.project")
     * MyScanConfig =>扫描com.example.project 包下的bean
     * */
    @Test
    public void MyScanConfigTest(){
        start(MyScanConfig.class);
    }

    /**
     * ANNOTATION
     *2.@ComponentScan(value = "com.example.project"
     *             ,includeFilters = {@Filter(type = FilterType.ANNOTATION ,value = {Controller.class})}
     *             ,useDefaultFilters = false)
     * */
    @Test
    public void scanAnnotationFilterTest(){
        start(MyScanFilterConfig.AnnotationFilter.class);
    }

    /**
     * ASSIGNABLE_TYPE
     * 3.@ComponentScan(value = "com.example.project"
      ,includeFilters = {@Filter(type = FilterType.ASSIGNABLE_TYPE ,value = {MyService.class})}
      ,useDefaultFilters = false)
     * 过滤出指定类型的Bean
     * */
    @Test
    public void scanAssignableTypeFilterTest(){
        start(MyScanFilterConfig.AssignableTypeFilter.class);
    }

    /**
     @ComponentScan(value = "com.example.project"
     ,includeFilters = {@Filter(type = FilterType.CUSTOM ,value = {MyTypeFilter.class})}
     ,useDefaultFilters = false)
     自定义filter
     * */
    @Test
    public void scanCustomTypeFilterTest(){
        start(MyScanFilterConfig.CustomTypeFilter.class);
    }
}
