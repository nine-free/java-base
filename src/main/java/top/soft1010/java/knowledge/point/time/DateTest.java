package top.soft1010.java.knowledge.point.time;

import java.util.Date;

/**
 * @author bjzhangjifu
 * @date 2019/3/22
 * @desc
 */
public class DateTest {

    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.getTime());
        System.out.println(now.getDate());
        System.out.println(now.getHours());

    }
}
