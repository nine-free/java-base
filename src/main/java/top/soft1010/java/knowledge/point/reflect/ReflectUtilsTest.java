package top.soft1010.java.knowledge.point.reflect;


import java.util.List;

/**
 * Created by zhangjifu on 19/10/10.
 */
public class ReflectUtilsTest {

    public static void main(String[] args) throws Exception {
        SubClass subClass = new SubClass();

        System.out.println("===获取构造函数===");
        ReflectUtils.parseConstructors(SubClass.class, false);
        System.out.println("===获取declared构造函数===");
        ReflectUtils.parseConstructors(SubClass.class, true);
        System.out.println("===获取fields===");
        ReflectUtils.parseFileds(SubClass.class, false);
        System.out.println("===获取declaredFields===");
        ReflectUtils.parseFileds(SubClass.class, true);
        System.out.println("===获取方法签名===");
        ReflectUtils.parseMethods(SubClass.class, false);
        System.out.println("===获取declared方法签名===");
        ReflectUtils.parseMethods(SubClass.class, true);
        System.out.println("===获取内部类===");
        ReflectUtils.parseInnerClass(SubClass.class, false);
        System.out.println("===获取declared内部类===");
        ReflectUtils.parseInnerClass(SubClass.class, true);
        System.out.println("===修改变量===");
        ReflectUtils.modifyFiled();
        System.out.println("===修改常量===");
        ReflectUtils.modifyFinalFiled();
        System.out.println("===反射动态调用方法 start===");
        ReflectUtils.invokePrivateMethod(SubClass.class);
        System.out.println("===可变参数的方法===");
        ReflectUtils.invokeMethod(subClass, "publicMethod", "1", "2", "3");
        //直接调用方法
        subClass.publicMethod("zhang", "123");
        System.out.println("===反射动态调用方法 end===");

        System.out.println("===华丽的分割线===");
        List<Class> classList = ReflectUtils.loacExtendClass("/Users/zhangjifu/myproject/java-base/src/main/java/");
        for (Class cls : classList) {
            ReflectUtils.parseFileds(cls, true);
            ReflectUtils.parseMethods(cls, true);
        }
        System.out.println("===华丽的分割线===");
        Class cls = Class.forName("top.soft1010.java.knowledge.point.reflect.OutSideClass");
        System.out.println(cls.getName());
    }

}
