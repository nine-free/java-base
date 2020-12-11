package cn.soft1010.java.async;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangjifu on 2020/12/6.
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Student student1 = new Student(countDownLatch, "student1");
        Student student2 = new Student(countDownLatch, "student2");
        Student student3 = new Student(countDownLatch, "student3");
        Student student4 = new Student(countDownLatch, "student4");
        Student student5 = new Student(countDownLatch, "student5");

        Teacher teacher = new Teacher("teacher", countDownLatch);

        executorService.execute(student1);
        executorService.execute(student2);
        executorService.execute(student3);
        executorService.execute(student4);
        executorService.execute(student5);
        executorService.execute(teacher);

        executorService.shutdown();
    }
}
