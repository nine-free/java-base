package top.soft1010.java.knowledge.point.generic;


import java.math.BigDecimal;

/**
 * @author bjzhangjifu
 * @date 2019/3/11
 */
public class Test {


    public static void main(String[] args) {

        FruitShop fruitShop = new FruitShop<>();
        fruitShop.addFruit(new Orange("orange"), new BigDecimal("10.10"));
        fruitShop.addFruit(new Apple("apple"), new BigDecimal("20.20"));

        //重写了Fruit类的equals方法 所以能取到数据
        System.out.println(fruitShop.getFruitPrice(new Orange("orange")).toString());

        System.out.println("---------");
        fruitShop.list();
    }
}
