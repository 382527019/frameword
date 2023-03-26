
package com.example.demo.annotation.compoemScan;

import com.example.project.po.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ComponentScan 扫描类
 */
@ComponentScan(value = "com.example.project")
@Configuration
public class MyScanConfig {
    /*1.类名首字母小写作为BeanName*/
    @Bean
    public Person person() {
        return new Person("person", 20);
    }
}
