package cn.soft1010.java.lambda;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by zhangjifu on 2020/12/8.
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Collections.sort(list, (s1, s2) -> (s1 + "").compareTo(s2));
        System.out.println(StringUtils.join(list, ","));

        System.out.println("========");

        DataServiceImpl dataService = new DataServiceImpl();
        dataService.execute(new Context(), context -> {
            System.out.println("--");
        });
        Handler handler = context -> {
            System.out.println("--");
        };
        handler.handle(new Context());

        boolean flag = check(null, context -> StringUtils.isNotBlank(context.getName()) ? true : false);
        System.out.println(flag);
    }

    private static boolean check(Context context, Predicate<Context> predicate) {
        if (predicate.test(context)) {
            return true;
        }
        return false;
    }

}
