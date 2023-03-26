
package com.example.demo.annotation.lazy;

import com.example.project.po.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Method;

/**
 * @Configuration 配置类
 */
@Configuration
public class MyLazyConfig {

    /**
     * 默认非延时加载
     * 延迟加载 ，懒加载只针对单例Bean起作用
     * 默认容器启动时不创建对象，调用对象功能时才创建
     * @return
     */
    @Lazy
    @Bean
    public Person person() {
        System.out.println("invoked bean function,will load Bean, have @lazy");
        return new Person("person", 20);
    }

    @Bean("beanName")
    public Person person2() {
        System.out.println("will load Bean ,have not @lazy");
        return new Person("beanName", 20);
    }

    @Lazy
    @Scope("prototype")
    @Bean
    public Person person1() {
        System.out.println("will load prototype Bean ,have not @lazy");
        return new Person("person1", 20);
    }

}
