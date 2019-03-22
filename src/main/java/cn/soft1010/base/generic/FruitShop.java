package cn.soft1010.base.generic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bjzhangjifu
 * @date 2019/3/22
 * @desc
 */
public class FruitShop<T extends Fruit, E extends Number> {

    ConcurrentHashMap<T, E> concurrentHashMap = new ConcurrentHashMap<>();

    public E getFruitPrice(T fruit) {
        return concurrentHashMap.get(fruit);
    }

    public void addFruit(T fruit, E price) {
        concurrentHashMap.put(fruit, price);
    }

    public void list() {
        for (Map.Entry<T, E> entry : concurrentHashMap.entrySet()
                ) {
            System.out.println(entry.getKey().getName() + ":" + entry.getValue().toString());
        }
    }
}
