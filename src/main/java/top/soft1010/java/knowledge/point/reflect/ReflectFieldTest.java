package top.soft1010.java.knowledge.point.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by zhangjifu on 19/10/8.
 */
public class ReflectFieldTest {

    public static void main(String[] args) {
        Class subClassClass = SubClass.class;

        //获取所有public的成员变量 包含本类和从子类继承来的
        Field[] fields1 = subClassClass.getFields();
        for (Field field : fields1) {
            System.out.print(Modifier.toString(field.getModifiers()) + " "
                    + field.getType().getName() + field.getName());
            System.out.println("");
        }
        System.out.println("====");
        //获取本类所有变量，所有权限
        Field[] fields2 = subClassClass.getDeclaredFields();

        for (Field field : fields2) {
            System.out.print(Modifier.toString(field.getModifiers()) + " "
                    + field.getType().getName() + field.getName());
            System.out.println("");
        }
    }
}
