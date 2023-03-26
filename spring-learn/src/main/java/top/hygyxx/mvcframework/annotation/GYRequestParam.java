package top.hygyxx.mvcframework.annotation;


import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GYRequestParam {
    String value() default "";

}
