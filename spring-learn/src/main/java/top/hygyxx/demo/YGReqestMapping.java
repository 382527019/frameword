package top.hygyxx.demo;

import java.lang.annotation.*;


@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YGReqestMapping {

    String value() default "";
}
