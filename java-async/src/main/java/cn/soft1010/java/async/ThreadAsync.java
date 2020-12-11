package cn.soft1010.java.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhangjifu on 2020/12/6.
 */
public class ThreadAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //异步 新建一个线程执行操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Thread do sth ... ...");
            }
        }).start();

        //异步 线程池提交一个异步请求
        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(" Executors do sth ... ...");
            }
        });

        //需要返回值
        Future future = Executors.newCachedThreadPool().submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000L);
                System.out.println("---do sth---");
                return "sth";
            }
        });
        String result = (String) future.get();
        System.out.println("异步返回值：" + result);

        // 多个线程存在依赖关系 使用 CountDownLatch


    }
}
