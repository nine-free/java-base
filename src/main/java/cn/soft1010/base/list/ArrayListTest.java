package cn.soft1010.base.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bjzhangjifu
 * @date 2019/3/21
 * @desc
 */
public class ArrayListTest {

    public static void main(String[] args) {
        User user1 = new User("1", "110001");
        User user2 = new User("2", "110002");
        User user3 = new User("3", "110003");
        User user4 = new User("4", "110004");
        User user5 = new User("5", "110005");
        User user6 = new User("6", "110006");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);

        List<User> subList = list.subList(1, 3);
        for (User user : subList) {
            System.out.println(user.toString());
        }

        subList.remove(1);
        for (User user : list) {
            System.out.println(user.toString());
        }

        try {

            list.add(new User("7", "110007"));
            for (User user : subList) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=================");
        User[] users = new User[list.size()];
        list.toArray(users);
        for (User user : users) {
            System.out.println("==");
            System.out.println(user.toString());
        }

    }

}
