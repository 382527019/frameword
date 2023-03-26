package com.example.demo.annotation.imports;

import com.example.project.service.ThirdPart3Service;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2023/3/26
 * Time:21:09
 */
public class MyFactoryBean implements FactoryBean<ThirdPart3Service> {
    @Override
    public ThirdPart3Service getObject() throws Exception {
        System.out.println("----getObject.");
        return new ThirdPart3Service("FactoryBean");
    }

    @Override
    public Class<?> getObjectType() {
        return ThirdPart3Service.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
