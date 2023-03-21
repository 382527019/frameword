package top.hygyxx.mvcframework.annotation;

import java.lang.annotation.*;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YGAutowired {

    String value() default "";
}
