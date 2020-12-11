package top.soft1010;

/**
 * Created by zhangjifu on 19/12/10.
 */
public class TT {
    static {
        System.out.println("static");
    }

    public static void test() {
        System.out.println(1);
    }

    class  T{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class PT{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
