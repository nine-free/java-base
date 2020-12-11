package top.soft1010;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by zhangjifu on 19/12/10.
 */
public class Test {

//    static int i = 0;
//
//    static {
//        i = 1;
//        System.out.println(i + "--");
//    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle = lookup.findStatic(TT.class, "test", MethodType.methodType(Void.TYPE));
        methodHandle.invoke();



        TT.T t = new TT().new T();
        TT.PT pt = new TT.PT();
    }


}
