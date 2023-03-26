package com.example.demo.annotation.imports;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2023/3/26
 * Time:20:27
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean thirdPartService = registry.containsBeanDefinition("com.example.project.service.ThirdPartService");
        boolean thirdPart1Service = registry.containsBeanDefinition("com.example.project.service.ThirdPart1Service");
        if (thirdPartService && thirdPart1Service){
            /*手动注册进IoC*/
            System.out.println("手动注册==》registry.registerBeanDefinition(name,beanDefinition)");
            RootBeanDefinition beanDefinition = new RootBeanDefinition("com.example.project.service.ThirdPart2Service");
            registry.registerBeanDefinition("thirdPart2Service", beanDefinition);
        }

    }
}
