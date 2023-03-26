package com.example.demo.annotation.imports;

import com.example.project.service.ThirdPartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1.直接import 类 eg：ThirdPartService
 * 2.实现ImportSelector接口自定义规则eg： MyImportSelector
 * 3.实现ImportBeanDefinitionRegistrar 获得BeanDefinitionRegistry手动注册IoC容器eg： MyImportBeanDefinitionRegistrar
 * 4.FactoryBean 把现有注册的对象封装成FactoryBean 注册到IoC eg：MyFactoryBean
 */
@ComponentScan(value = "com.example.project")
@Configuration
@Import({ThirdPartService.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MyImportConfig {

    /**
     * MyFactoryBean
     * 使用：&beanName
     *          Object factoryBean = app.getBean("&thirdPart3Service");
     *         System.out.println(factoryBean);
     *         ThirdPart3Service thirdPart3Service = (ThirdPart3Service)app.getBean("thirdPart3Service");
     *         System.out.println(thirdPart3Service);
     * @return
     */
    @Bean
    public MyFactoryBean thirdPart3Service(){
        System.out.println("MyFactoryBean registrar.");
        return new MyFactoryBean();
    }
}
