package top.soft1010.java.knowledge.point;

/**
 * Created by bjzhangjifu on 2019/4/30.
 */
public class Test {

    public static void main(String[] args) {
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String str = new String("1");
        ClassLoader classLoader = str.getClass().getClassLoader();
        System.out.println(str);

        Integer integer = new Integer(1);
        ClassLoader classLoader1 = integer.getClass().getClassLoader();
//        System.out.println(classLoader1.getParent());

        ClassLoader classLoader2 = new Test().getClass().getClassLoader();
        System.out.println(classLoader2.getParent());

        ClassLoader classLoader3 = javax.swing.text.html.HTML.class.getClassLoader();
        System.out.println(classLoader3.getParent());
    }

}
