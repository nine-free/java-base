package top.soft1010.java.knowledge.point.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bjzhangjifu
 * @date 2019/3/11
 */
public class ListTest {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("zhang", "123789371983"));
        userList.add(new User("li", "12312312312222"));
        User[] userarr = {new User("zhang", "123789371983"), new User("li", "12312312312222")};
        List<User> users = Arrays.asList(userarr);
        for (User user : users) {
            System.out.println(user.getName() + "---" + user.getIdcard());
        }
        try {
            /**
             * 对于Arrays.asList(） 只实现了转化为List集合，
             * list接口的clear add remove等方法都没有实现 会抛出异常
             *
             */
            users.add(new User("wang", "12312"));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
