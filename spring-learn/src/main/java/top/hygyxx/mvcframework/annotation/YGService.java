package top.hygyxx.mvcframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YGService {
    String name() default "";

    String value() default "";
}
