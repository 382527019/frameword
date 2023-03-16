package top.hygyxx.mvcframework.annotation;

import javax.servlet.annotation.WebServlet;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YGController {
    String name() default "";
    String value() default "";

}
