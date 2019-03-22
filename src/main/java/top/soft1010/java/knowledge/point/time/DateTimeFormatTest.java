package top.soft1010.java.knowledge.point.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author bjzhangjifu
 * @date 2019/3/22
 * @desc
 */
public class DateTimeFormatTest {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(LocalDate.parse("2019-03-12", dateTimeFormatter));
    }
}
