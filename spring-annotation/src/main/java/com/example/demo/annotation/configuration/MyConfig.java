
package com.example.demo.annotation.configuration;

import com.example.project.po.Person;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 配置类
 */
@Configuration
public class MyConfig {

    /*1.类名首字母小写作为BeanName*/
    @Bean
    public Person person() {
        return new Person("person", 20);
    }
    /*2.方法名作为BeanName*/
    @Bean
    public Person person1() {
        return new Person("person1", 20);
    }

    /*3.优先取注解value作为BeanName*/
    @Bean("beanName")
    public Person person2() {
        return new Person("person2", 20);
    }

}
