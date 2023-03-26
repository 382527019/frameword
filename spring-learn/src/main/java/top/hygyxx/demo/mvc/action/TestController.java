package top.hygyxx.demo.mvc.action;

import top.hygyxx.demo.mvc.service.IDemoService;
import top.hygyxx.mvcframework.annotation.GYRequestParam;
import top.hygyxx.mvcframework.annotation.YGAutowired;
import top.hygyxx.mvcframework.annotation.YGController;
import top.hygyxx.mvcframework.annotation.YGReqestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@YGController
public class TestController {
    @YGAutowired
    private IDemoService demoService;

    @YGReqestMapping("/test")
    public void test( HttpServletRequest req, HttpServletResponse resp,
                      @GYRequestParam("name") String name,
                      @GYRequestParam("type") String type) {
        String test = demoService.test(name);
        try {
            resp.getWriter().write(test);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
