package top.soft1010.java.knowledge.point.reflect.reflections;

import java.lang.annotation.*;

/**
 * Created by bjzhangjifu on 2018/10/16.
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodHandler {
    String value() default "";
}
