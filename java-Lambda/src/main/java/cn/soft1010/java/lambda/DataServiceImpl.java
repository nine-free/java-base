package cn.soft1010.java.lambda;

/**
 * Created by zhangjifu on 2020/12/8.
 */
public class DataServiceImpl implements DataService {

    @Override
    public void execute(Context context, Handler handler) {
        handler.handle(context);
    }
}
