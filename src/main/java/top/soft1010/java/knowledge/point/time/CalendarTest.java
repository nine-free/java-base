package top.soft1010.java.knowledge.point.time;

import java.util.Calendar;

/**
 * @author bjzhangjifu
 * @date 2019/3/22
 * @desc
 */
public class CalendarTest {


    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.toString());
        System.out.println(calendar.getTime());
        System.out.println(getDateStr(calendar));

    }

    private static String getDateStr(Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(calendar.get(Calendar.YEAR)).append("-")
                .append(calendar.get(Calendar.MONTH)).append("-")
                .append(calendar.get(Calendar.DAY_OF_MONTH)).append(" ")
                .append(calendar.get(Calendar.HOUR_OF_DAY)).append(":")
                .append(calendar.get(Calendar.MINUTE)).append(":")
                .append(calendar.get(Calendar.SECOND));
        return stringBuffer.toString();
    }


}
