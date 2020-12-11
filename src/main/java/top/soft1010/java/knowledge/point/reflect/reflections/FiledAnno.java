package top.soft1010.java.knowledge.point.reflect.reflections;

import java.lang.annotation.*;

/**
 * Created by zhangjifu on 19/10/15.
 */
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FiledAnno {
}
