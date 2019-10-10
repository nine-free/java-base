package top.soft1010.java.knowledge.point.reflect;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhangjifu on 19/10/9.
 */
public class MethodTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SubClass subClass = new SubClass();

        Class cls = subClass.getClass();
        System.out.println("调用私有方法");
        //获取指定方法
        Method privateMethod = cls.getDeclaredMethod("privateMethod", String.class, Integer.class);
        //对于private方法，需要设置访问权限
        privateMethod.setAccessible(true);

        privateMethod.invoke(subClass, "zhang", 321);
        System.out.println("调用公有方法");
        //获取指定方法
        Method publicMethod = cls.getDeclaredMethod("publicMethod", String.class, Integer.class);
        //对于public方法，不需要设置访问权限
//        publicMethod.setAccessible(true);

        publicMethod.invoke(subClass, "zhang", 123456);


    }
}
