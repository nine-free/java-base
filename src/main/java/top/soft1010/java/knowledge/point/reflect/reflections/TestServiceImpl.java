package top.soft1010.java.knowledge.point.reflect.reflections;

/**
 * Created by zhangjifu on 19/10/15.
 */
public class TestServiceImpl implements TestService {

    @FiledAnno
    private String filedName;

    @MethodHandler(value = "methodHandler")
    @Override
    public void test() {

    }
}
