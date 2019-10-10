package top.soft1010.java.knowledge.point.reflect;

import java.lang.reflect.Field;

/**
 * Created by zhangjifu on 19/10/10.
 */
public class FiledTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        modifyFiled();

        modifyFinalFiled();
    }

    private static void modifyFiled() throws NoSuchFieldException, IllegalAccessException {
        SubClass subClass = new SubClass();
        subClass.setSubName("subname");
        Class cls = subClass.getClass();

        Field field = cls.getDeclaredField("subName");
        System.out.println();
        //设置访问权限
        field.setAccessible(true);
        System.out.println("old subname:" + subClass.getSubName());
        //field是私有变量 subClass是要修改的对象 subNameNew是修改成的目标值
        field.set(subClass, "subNameNew");
        System.out.println("new subname:" + subClass.getSubName());

    }

    private static void modifyFinalFiled() throws NoSuchFieldException, IllegalAccessException {
        SubClass subClass = new SubClass();
        Class cls = subClass.getClass();

        Field field = cls.getDeclaredField("finalInt");
        System.out.println("私有变量finalInt 通过反射修改 值 1--> 2");
        //设置访问权限
        field.setAccessible(true);
        //直接获取对象指定私有常量的值
        System.out.println("反射前 finalInt:" + field.get(subClass));
        //通过get方法获取私有常量的值
        System.out.println("反射前 getfinalInt():" + subClass.getFinalInt());
        //field是私有变量 subClass是要修改的对象 subNameNew是修改成的目标值
        field.set(subClass, 2);
        //直接获取修改后对象指定私有常量的值
        System.out.println("反射后 finalInt:" + field.get(subClass));
        //通过get方法获取修改后私有常量的值
        System.out.println("反射后 getfinalInt():" + subClass.getFinalInt());

        System.out.println("===华丽的分割线===");
        System.out.println("私有变量finalInteger 通过反射修改 11-->12");
        Field field1 = cls.getDeclaredField("finalInteger");
        //设置访问权限
        field1.setAccessible(true);
        //直接获取对象指定私有常量的值
        System.out.println("反射前 finalInteger:" + field1.get(subClass));
        //通过get方法获取私有常量的值
        System.out.println("反射前 getfinalInteger():" + subClass.getFinalInteger());
        //field是私有变量 subClass是要修改的对象 subNameNew是修改成的目标值
        field1.set(subClass, 12);
        //直接获取修改后对象指定私有常量的值
        System.out.println("反射后 finalInteger:" + field1.get(subClass));
        //通过get方法获取修改后私有常量的值
        System.out.println("反射后 getfinalInteger():" + subClass.getFinalInteger());

    }
}
