
package com.example.demo.annotation.conditional;

import com.example.project.po.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 配置类
 */
@Configuration
public class MyConditionalConfig {

    /**
     *  WindowsCondition 实现Condition接口
     * @return
     */
    @Conditional(WindowsCondition.class)
    @Bean
    public Person person() {
        System.out.println("windows load...");
        return new Person("windows", 20);
    }
    @Conditional(LinuxCondition.class)
    @Bean
    public Person person1() {
        System.out.println("linux load...");

        return new Person("linux", 20);
    }


}
