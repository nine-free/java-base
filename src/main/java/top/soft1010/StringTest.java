package top.soft1010;

/**
 * Created by zhangjifu on 19/11/21.
 */
public class StringTest {
    public static void main(String[] args) {

        String str = new StringBuffer().append("计算机").append("软件").toString();
        String ss = "计算机软件";
//        String str = "java";
        System.out.println(str.intern() == str);
        System.out.println(ss==str);
        System.out.println(ss==str.intern());

        String str1 = new StringBuffer().append("ja").append("va").toString();
//        String str = "java";
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer().append("stati").append("c").toString();
//        String str = "java";
        System.out.println(str2.intern() == "static");


        String s2 = new String("456");
        String s1 = "456";
        System.out.println(s1.intern()==s2);



    }
}
