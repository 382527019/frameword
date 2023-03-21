package top.hygyxx.mvcframework.annotation;

import java.lang.annotation.*;


@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YGReqestMapping {

    String value() default "";
}
