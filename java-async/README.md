
## 1、异步-->通过创建一个新线程 new Thread
```
        //异步 新建一个线程执行操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Thread do sth ... ...");
            }
        }).start();
```
## 2、异步-->通过线程池 Executors
```
        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(" Executors do sth ... ...");
            }
        });
```
## 3、异步-->需要返回值
```
        Future future = Executors.newCachedThreadPool().submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000L);
                System.out.println("---do sth---");
                return "sth";
            }
        });
        String result = (String) future.get();
```

## 4、异步-->多个线程存在依赖关系 使用CountDownLatch
#### CountDownLatch的使用
学生类
```
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
    //学生写作业
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
```
老师类
```
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
    //老师批改作业
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
```
假如有五名学生，老师要等所有学生写完作业只有批改作业
```
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
```
输出:
```
teacher do sth ... ... 
student2 do home work ... ...
student5 do home work ... ...
student3 do home work ... ...
student4 do home work ... ...
student1 do home work ... ...
teacher check home work ... ...
```
#### CountDownLatch核心接口
```youtrack
//调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
public void await() throws InterruptedException { };   
//和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };  
//将count值减1
public void countDown(){ }; 
```
#### CountDownLatch原理
```
CountDownLatch是一个计数器，线程完成一个记录一个，计数器递减，只能用一次
```

## CyclicBarrier
d
```
public class Member implements Runnable {

    private String name;

    private CyclicBarrier cyclicBarrier;

    public Member(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            prepared();
            cyclicBarrier.await();
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
```

```
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("每十个人准备好 开一桌饭 ... ...");
            }
        });

        for (int i = 0; i < 100; i++) {
            Executors.newCachedThreadPool().execute(
                    new Member(new String("第" + i + "个成员"), cyclicBarrier));
        }
```