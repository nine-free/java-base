package cn.soft1010.base;

/**
 * @author bjzhangjifu
 * @date 2019/3/14
 */
public class IntegerTest {

    public static void main(String[] args) {

        /**
         * Integer 包装类的-128 到 127使用的是IntegerCache.cache里的数组元素 所以是同一个对象
         */
        Integer i1 = 1;
        Integer i2 = 1;

        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;

        System.out.println(i3 == i4);
    }
}
