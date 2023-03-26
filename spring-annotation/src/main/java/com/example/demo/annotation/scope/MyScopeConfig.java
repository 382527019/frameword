
package com.example.demo.annotation.scope;

import com.example.project.po.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Configuration 配置类
 */
@Configuration
public class MyScopeConfig {

    /*
    @Scope 用在类上
    1.prototype 原型，多例
        singleton 单例
        request 同一次web请求只创建一个实例
        session 同一个session只创建一个对象
    * */
    @Scope("prototype")
    @Bean
    public Person person() {
        return new Person("person", 20);
    }

}
