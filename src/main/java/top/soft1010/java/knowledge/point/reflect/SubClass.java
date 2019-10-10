package top.soft1010.java.knowledge.point.reflect;

/**
 * Created by zhangjifu on 19/10/8.
 */
public class SubClass extends SupperClass {

    public static final String sub_default_value = "123456";
    private final String finalString = "final String";
    private final int finalInt = 1;
    private final Integer finalInteger = 11;

    private Integer id;
    private String subName;

    public void publicMethod(String name, Integer id) throws NullPointerException, ClassCastException {
        System.out.println("===name:" + name + "  id:" + id + "===");
    }
    private void privateMethod(String name, Integer id) throws NullPointerException, ClassCastException {
        System.out.println("===name:" + name + "  id:" + id + "===");
    }

    public String getFinalString() {
        return finalString;
    }

    public int getFinalInt() {
        return finalInt;
    }

    public Integer getFinalInteger() {
        return finalInteger;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    //内部类
    public class InnerSubClass {

    }

}
