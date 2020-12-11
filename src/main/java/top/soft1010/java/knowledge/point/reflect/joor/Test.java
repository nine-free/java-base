package top.soft1010.java.knowledge.point.reflect.joor;

import org.joor.Reflect;

/**
 * Created by zhangjifu on 19/10/23.
 */
public class Test {

    private String name;

    public Test(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        String name =
                //构造reflect对象
                Reflect.on("top.soft1010.java.knowledge.point.reflect.joor.Test")
                        //调用构造方法构造对象
                        .create("zhang")
                        //可变参数的方法调用
                        .call("test1", new Object[]{new String[]{"1", "2", "3"}})
                        //调用方法
                        .call("test")
                        //获取field
                        .get("name");
        System.out.println(name);
    }

    private Test test() {
        System.out.println(name);
        return this;
    }

    private void test1(String... args) {
        for (String arg : args) {
            System.out.println(arg.toString());
        }
    }
}
