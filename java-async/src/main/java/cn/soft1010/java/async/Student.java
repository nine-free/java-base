package cn.soft1010.java.async;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangjifu on 2020/12/6.
 */
public class Student implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;

    public Student(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public Student(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            doHomeWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doHomeWork() throws InterruptedException {
        Thread.sleep(new Random().nextInt(10000));
        System.out.println(getName() + " do home work ... ...");
        countDownLatch.countDown();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
