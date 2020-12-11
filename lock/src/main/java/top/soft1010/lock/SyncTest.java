package top.soft1010.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * Created by zhangjifu on 2019/12/18.
 */
public class SyncTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SyncTest test = new SyncTest();
        ObjTest objTest = new ObjTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future> ff = new ArrayList<>();
        IntStream.range(0, 10000).forEach(i -> ff.add(executorService.submit(new Runnable() {
            @Override
            public void run() {
                test.test1();
                test.test2();
                test.test3();
                test.test4(objTest);
                objTest.add();
                objTest.addsync();
            }
        })));

        ff.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println(test.count1);
        System.out.println(test.count2);
        System.out.println(test.count3);

        System.out.println(objTest.getM());
        System.out.println(objTest.get());
        System.out.println(objTest.getN());

        ff.forEach();

    }

    int count1 = 0;
    static int count2 = 0;
    int count3 = 0;

    //非线程安全
    public int test1() {
        return count1++;
    }

    //非线程安全
    public static int test2() {
        return count2++;
    }

    //线程安全
    public synchronized int test3() {
        return count3++;
    }

    public synchronized void test4(ObjTest objTest) {
        objTest.add2();
    }

}
