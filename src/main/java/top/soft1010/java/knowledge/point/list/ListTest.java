package top.soft1010.java.knowledge.point.list;

import java.util.*;

/**
 * @author bjzhangjifu
 * @date 2019/3/11
 */
public class ListTest {

    public static void main(String[] args) {
//        List<User> userList = new ArrayList<User>();
//        userList.add(new User("zhang", "123789371983"));
//        userList.add(new User("li", "12312312312222"));
//        User[] userarr = {new User("zhang", "123789371983"), new User("li", "12312312312222")};
//        List<User> users = Arrays.asList(userarr);
//        for (User user : users) {
//            System.out.println(user.getName() + "---" + user.getIdcard());
//        }
//        try {
//            /**
//             * 对于Arrays.asList(） 只实现了转化为List集合，
//             * list接口的clear add remove等方法都没有实现 会抛出异常
//             *
//             */
//            users.add(new User("wang", "12312"));
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        System.out.println("=============");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

//        for (Integer integer : list) {
//            try {
//                if (integer == 1) {
//                    list.remove(integer);
//                    list.add(new Integer(3));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println(list.size());
//        System.out.println("===========");
//        Iterator<Integer> integerIterator = list.iterator();
//        while (integerIterator.hasNext()) {
//            if (integerIterator.next().equals(1)) {
//                integerIterator.remove();
//            }
//        }
//        System.out.println(list.size());


        System.out.println("==================");

        List<Integer> list1 = new ArrayList<>(2);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
    }

}
