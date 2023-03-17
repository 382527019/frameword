package top.hygyxx.demo;

import java.lang.annotation.*;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YGAutowired {

    String value() default "";
}
