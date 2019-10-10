package top.soft1010.java.knowledge.point.reflect;


import java.util.List;

/**
 * Created by zhangjifu on 19/10/10.
 */
public class ReflectUtilsTest {

    public static void main(String[] args) throws Exception {
        SubClass subClass = new SubClass();
        ReflectUtils.parseFileds(SubClass.class);
        System.out.println("===华丽的分割线===");
        ReflectUtils.parseDeclaredFileds(SubClass.class);
        System.out.println("===华丽的分割线===");
        ReflectUtils.parseMethods(SubClass.class);
        System.out.println("===华丽的分割线===");
        ReflectUtils.parseInnerClass(SubClass.class);
        System.out.println("===华丽的分割线===");
        ReflectUtils.parseInnerDeclaredClass(SubClass.class);
        System.out.println("===华丽的分割线===");
        ReflectUtils.modifyFiled();
        System.out.println("===华丽的分割线===");
        ReflectUtils.modifyFinalFiled();
        ReflectUtils.invokePrivateMethod(SubClass.class);
        System.out.println("===华丽的分割线===");
        List<Class> classList = ReflectUtils.loacExtendClass("/Users/zhangjifu/myproject/java-base/src/main/java/");
        for (Class cls : classList) {
            ReflectUtils.parseDeclaredFileds(cls);
            ReflectUtils.parseMethods(cls);
        }
    }

}
