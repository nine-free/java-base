package cn.soft1010.base;

import org.apache.commons.lang3.StringUtils;

/**
 * @author bjzhangjifu
 * @date 2019/3/18
 */
public class StringSplitTest {

    public static void main(String[] args) {


        String str = ",,1,2,3,,";
        String[] arr = str.split(",");

        System.out.println(arr.length);
        System.out.println(arr[0]);
        System.out.println(arr[arr.length - 1]);

        String[] arrr = StringUtils.split(str, ",");
        System.out.println(arrr.length);

    }
}
