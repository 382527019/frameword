package top.hygyxx.demo.mvc.service.impl;

import top.hygyxx.demo.mvc.service.IDemoService;
import top.hygyxx.mvcframework.annotation.YGService;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2023/3/21
 * Time:23:00
 */
@YGService
public class IDemoServiceImpl implements IDemoService {
    @Override
    public String test(String name) {
        return name;
    }
}
