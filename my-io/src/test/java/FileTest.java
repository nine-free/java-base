import org.junit.Test;
import top.soft1010.io.FileUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangjifu on 19/11/18.
 */
public class FileTest {

    @Test
    public void testFileUtil() {

        try {
            File file = FileUtil.createFile("/Users/zhangjifu/myproject/java-base", "tmp.txt");
            System.out.println(file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
