package cn.soft1010.base.jdk8;

/**
 * @author bjzhangjifu
 * @date 2019/3/12
 */
public class interfaceTest {

    public static void main(String[] args) {
        InterfaceAPI.test1();
        new InterfaceAPIImpl().test2();
        new InterfaceAPIImpl2().test2();
    }
}
