package com.example.demo.annotation.compoemScan;

import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2023/3/26
 * Time:17:27
 */
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader 当前正在操作类的信息
     * @param metadataReaderFactory 获取当前上下文所有信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        /*获取当前类所有注解信息*/
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        /*获取当前扫描到的类信息*/
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        /*获取当前类所有资源*/
        Resource resource = metadataReader.getResource();
        System.out.println("扫描到：----className:"+classMetadata.getClassName());
        if (classMetadata.getClassName().contains("My")){
            return true;
        }
        return false;
    }
}
