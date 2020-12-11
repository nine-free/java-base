package cn.soft1010.java.async;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * Created by zhangjifu on 2020/12/6.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("每十个人准备好 开一桌饭 ... ...");
            }
        });

        for (int i = 0; i < 108; i++) {
            Executors.newCachedThreadPool().execute(
                    new Member(new String("第" + i + "个成员"), cyclicBarrier));
        }
    }
}
