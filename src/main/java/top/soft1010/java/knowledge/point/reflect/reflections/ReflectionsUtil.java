package top.soft1010.java.knowledge.point.reflect.reflections;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by zhangjifu on 19/10/15.
 */
public class ReflectionsUtil {
    public static final String BASE_PACKAGE = "top.soft1010";

    //找出被指定注解类标注的所有接口、类
    public static void getTypesAnnotatedWith() {
        Set<Class<?>> annotationSet = getFullReflections(BASE_PACKAGE).getTypesAnnotatedWith(Handler.class);
        for (Class<?> clazz : annotationSet) {
            System.out.println(clazz.getName());
            Handler annotation = clazz.getAnnotation(Handler.class);
            System.out.println("name:" + annotation.name() + " value" + annotation.value());
        }
    }

    //找出指定接口的所有子类
    public static void getSubTypesOf() {
        Set<Class<? extends TestService>> classes = getFullReflections(BASE_PACKAGE).getSubTypesOf(TestService.class);
        for (Class<?> clazz : classes) {
            System.out.println(clazz.getName());
        }
    }

    //查找有某个注解类的方法
    public static void getMethodsAnnotatedWith() {
        Set<Method> methodSet = getFullReflections(BASE_PACKAGE).getMethodsAnnotatedWith(MethodHandler.class);
        for (Method m : methodSet) {
            System.out.println(m.getDeclaringClass().getName());
            System.out.println(m.getName());
        }
    }

    //查找有某个注解类的字段
    public static void getFieldsAnnotatedWith() {
        Set<Field> fieldSet = getFullReflections(BASE_PACKAGE).getFieldsAnnotatedWith(FiledAnno.class);
        for (Field f : fieldSet) {
            System.out.println(f.getName());
        }
    }


    /**
     * 如果没有配置scanner，默认使用SubTypesScanner和TypeAnnotationsScanner
     *
     * @param basePackage 包路径
     */
    public static Reflections getFullReflections(String basePackage) {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addUrls(ClasspathHelper.forPackage(basePackage));
        builder.setScanners(new TypeAnnotationsScanner(), new SubTypesScanner(),
                new MethodAnnotationsScanner(), new FieldAnnotationsScanner());
        builder.filterInputsBy(new FilterBuilder().includePackage(basePackage));

        Reflections reflections = new Reflections(builder);
        return reflections;
    }
}
