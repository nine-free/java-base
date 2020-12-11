package cn.soft1010.java.async;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by zhangjifu on 2020/12/6.
 */
public class Member implements Runnable {

    private String name;
    static int num = 0;

    private CyclicBarrier cyclicBarrier;

    public Member(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            prepared();
            try {
                cyclicBarrier.await(50, TimeUnit.SECONDS);
            } catch (TimeoutException e) {

                System.out.println(getName() + "------");
                e.printStackTrace();
            }

            doEat();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void prepared() throws BrokenBarrierException, InterruptedException {
        Thread.sleep(new Random().nextInt(10000));
        System.out.println(getName() + " 准备好了 等待开饭... ");
    }

    private void doEat() throws InterruptedException {
        Thread.sleep(new Random().nextInt(10000));
        System.out.println(getName() + " 开始吃饭 ... ...");
        num++;
        System.out.println(num);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
}
