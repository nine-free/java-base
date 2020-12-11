package top.soft1010.java.knowledge.point;

/**
 * Created by zhangjifu on 2020/10/24.
 */
public class Person {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String sayHello() {
        String result = "hello " + getName();
        return result;
    }

    public static void main(String[] args) {
        Person person = new Person("zhang", 30);

        String str = person.sayHello();
        System.out.println(str);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
