package top.soft1010.java.knowledge.point.collections;

import java.util.*;

/**
 * @author bjzhangjifu
 * @date 2019/3/25
 * @desc
 */
public class CollectionsTest {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(1);
//        list.add(4);
//        list.add(3);
//        list.add(4);
//        list.add(4);
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
////                if (o1.intValue() == o2.intValue()) {
////                    return 0;
////                }
//                return o1 > o2 ? 1 : -1;
//            }
//        });
//
//        list.forEach(integer -> System.out.println(integer));
        Map<Integer, Integer> map = new HashMap<>(10, 0.7f);

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 3);
        map.put(5, 4);
        map.put(6, 4);
        map.put(7, 4);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 3);
        map.put(5, 4);
        map.put(6, 4);
        map.put(7, 4);
        System.out.println(map.get(7));

    }

}
