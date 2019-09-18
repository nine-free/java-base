package top.soft1010.java.knowledge.point.fail_fast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bjzhangjifu on 2019/9/18.
 */
public class FailFastTest {

    public static void main(String[] args) {
        test3();

    }

    private static void test5(){
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();

    }

    private static void test4(){
        BigDecimal bigDecimal = new BigDecimal(19);
        bigDecimal.divide(new BigDecimal(0));
    }

    private static void test3() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        for (int i = 0; i < list.size(); i++) {
            list.add("c");
        }
        for (String str : list) {
            System.out.println(str);
        }
    }

    private static void test2() {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        for (String str : list) {
            list.add("c");
        }
        for (String str : list) {
            System.out.println(str);
        }
    }

    private static void test1() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Iterator<String> iterator = list.iterator();
        list.add("c");
        String n = iterator.next();
        System.out.println(n);

        for (String str : list) {
            System.out.println(str);
        }
        System.out.println();
    }
}
