package top.soft1010.java.knowledge.point.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bjzhangjifu on 2019/3/26.
 */
public class ExecutorTest {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.activeCount() + "------");
            }
        });

        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.submit(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.activeCount() + "------");
            }
        });
    }
}
