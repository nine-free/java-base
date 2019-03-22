package top.soft1010.java.knowledge.point.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author bjzhangjifu
 * @date 2019/3/22
 * @desc
 */
public class SimpleDateFormatTest {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(Calendar.getInstance().getTime()));

    }
}
