package top.soft1010.java.knowledge.point.list;

import java.io.Serializable;

/**
 * @author bjzhangjifu
 * @date 2019/3/11
 */
public class User implements Serializable {

    private String name;
    private String idcard;

    public User(String name, String idcard) {
        this.name = name;
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                '}';
    }
}
