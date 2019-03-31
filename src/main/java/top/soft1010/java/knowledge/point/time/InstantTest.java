package top.soft1010.java.knowledge.point.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by bjzhangjifu on 2019/3/26.
 */
public class InstantTest {


    public static void main(String[] args) {
        //Instant Date互相装换
        Instant instant = Instant.now();
        Date date = Date.from(instant);
        Instant instant1 = date.toInstant();
        System.out.println(instant);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(localDateTime.getYear()).append(
                localDateTime.getMonthValue()).append(
                localDateTime.getDayOfMonth()).append(
                localDateTime.getHour()).append(
                localDateTime.getMinute()).append(
                localDateTime.getSecond());
        System.out.println(localDateTime);
        System.out.println(stringBuffer.toString());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateTimeFormatter.format(localDateTime);
        System.out.println(dateStr);

        LocalDateTime localDateTime1 = LocalDateTime.parse(dateStr, dateTimeFormatter);
        System.out.println(localDateTime1);

    }
}
