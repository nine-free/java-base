package top.soft1010.java.knowledge.point.reflect;


import java.lang.reflect.Method;

/**
 * Created by zhangjifu on 19/10/12.
 */
public class Test {

    public static void main(String[] args) {
        int sum = 100000;
        long start = System.currentTimeMillis();
        SubClass subClass = new SubClass();
        for (int i = 0; i < sum; i++) {
            subClass.setName("zhang");
            subClass.setId(123);
            subClass.publicMethod("zhang", "123");
        }

        long time = System.currentTimeMillis();
        try {
            for (int i = 0; i < sum; i++) {
                Method method = subClass.getClass().getDeclaredMethod("publicMethod", String.class, String.class);
                //对于private方法，需要设置访问权限
                method.setAccessible(true);
                method.invoke(subClass, "zhang", 123);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("直接调用方法：" + (time - start));
        System.out.println("反射调用:"+(System.currentTimeMillis() - time));

    }
}
