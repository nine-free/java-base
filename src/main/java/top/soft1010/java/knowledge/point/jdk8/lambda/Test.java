package top.soft1010.java.knowledge.point.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bjzhangjifu
 * @date 2019/3/12
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");


        list.forEach(e -> System.out.println(e));

        list.sort((e1, e2) -> {
            return e2.compareTo(e1);
        });

        list.forEach(e -> System.out.println(e));
    }

}
