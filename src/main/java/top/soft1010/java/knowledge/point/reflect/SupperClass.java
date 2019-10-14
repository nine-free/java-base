package top.soft1010.java.knowledge.point.reflect;

/**
 * Created by zhangjifu on 19/10/8.
 */
public class SupperClass extends Object {


    private Integer id;
    private String name;
    public static final String super_default_value = "123456";

    public SupperClass() {
    }

    public SupperClass(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public 内部类
    public class InnerSuperClass {

    }

    //protected 内部类
    protected class InnerSuperClass2 {

    }

    //private 内部类
    private class InnerSuperClass3 {

    }
}
