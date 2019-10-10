package top.soft1010.java.knowledge.point.reflect;

/**
 * Created by zhangjifu on 19/10/8.
 */
public class ReflectClassTest {

    public static void main(String[] args) {
        Class subClass = SubClass.class;

        //getDeclaredClasses 得到该类所有的内部类，除去父类的
        Class[] classes = subClass.getDeclaredClasses();
        for (Class cls : classes) {
            System.out.println(cls.getName());
        }
        System.out.println("========");

        //getClasses得到该类及其父类所有的public的内部类。
        Class[] classes1 = subClass.getClasses();
        for (Class cls : classes1) {
            System.out.println(cls.getName());
        }
    }
}
