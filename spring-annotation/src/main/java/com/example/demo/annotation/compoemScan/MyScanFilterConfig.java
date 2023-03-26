
package com.example.demo.annotation.compoemScan;

import com.example.project.po.Person;
import com.example.project.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


/**
 * @ComponentScan 扫描类
 * includeFilters: 包含过滤器
 * useDefaultFilters:使用默认过滤器？
 */
public class MyScanFilterConfig {

    /**
     * 2.FilterType.ANNOTATION 过滤器，过滤出指定的注解Bean
     */
    @ComponentScan(value = "com.example.project"
            ,includeFilters = {@Filter(type = FilterType.ANNOTATION ,value = {Controller.class})}
            ,useDefaultFilters = false)
    @Configuration
     static class AnnotationFilter{
    }

    /**
     * 3.FilterType.ASSIGNABLE_TYPE 过滤器，过滤出指定类型的Bean
     */
    @ComponentScan(value = "com.example.project"
            ,includeFilters = {@Filter(type = FilterType.ASSIGNABLE_TYPE ,value = {MyService.class})}
            ,useDefaultFilters = false)
    @Configuration
    static class AssignableTypeFilter{
    }

    /**
     * 4.FilterType.CUSTOM 过滤器，自定义过滤规则
     */
    @ComponentScan(value = "com.example.project"
            ,includeFilters = {@Filter(type = FilterType.CUSTOM ,value = {MyTypeFilter.class})}
            ,useDefaultFilters = false)
    @Configuration
    static class CustomTypeFilter{
    }
}
