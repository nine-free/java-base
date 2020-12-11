package top.soft1010.lock;

/**
 * Created by zhangjifu on 2019/12/18.
 */
public class ObjTest {

    public int i = 0;
    public int n = 0;
    public int m = 0;

    //非线程安全
    public int add() {
        return i++;
    }

    public int add2() {
        return m++;
    }

    //线程安全
    public synchronized int addsync() {
        return n++;
    }

    public int get() {
        return i;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

}
