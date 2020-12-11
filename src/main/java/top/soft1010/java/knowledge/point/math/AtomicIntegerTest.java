package top.soft1010.java.knowledge.point.math;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangjifu on 2020/9/22.
 */
public class AtomicIntegerTest {

    static ExecutorService executorService = new ThreadPoolExecutor(
            50, 50, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10000));

    public static void main(String[] args) {
        final int[] num = {0};
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int size = 5000;
        List<Future> ff = new ArrayList();
        for (int i = 0; i < size; i++) {
            ff.add(executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    synchronized (num) {
                        num[0]++;
                    }
                    atomicInteger.incrementAndGet();
                    return null;
                }
            }));
        }
        for (Future f : ff) {
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(num[0]);
        System.out.println(atomicInteger.get());
    }
}
