package cn.soft1010.base.jdk8;

/**
 * @author bjzhangjifu
 * @date 2019/3/12
 */
public interface InterfaceAPI {

    /**
     * jdk8 新特性  支持static方法，直接实用接口调用
     */
    public static void test1() {
        System.out.println("test1 jdk8 static method");
    }

    /**
     * jdk8 新特性 支持default 关键字修饰 默认实现
     */
    default void test2() {
        System.out.println("test2 default method");
    }
}
