package cn.soft1010.java.async;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangjifu on 2020/12/6.
 */
public class Teacher implements Runnable {

    private String name;
    private CountDownLatch countDownLatch;

    public Teacher(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            checkHomeWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkHomeWork() throws InterruptedException {
        System.out.println(getName() + " do sth ... ... ");
        Thread.sleep(new Random().nextInt(10000));
        countDownLatch.await();
        System.out.println(getName() + " check home work ... ...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
