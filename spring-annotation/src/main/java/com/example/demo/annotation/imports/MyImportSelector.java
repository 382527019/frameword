package com.example.demo.annotation.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2023/3/26
 * Time:20:20
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.example.project.service.ThirdPart1Service"};
    }
}
