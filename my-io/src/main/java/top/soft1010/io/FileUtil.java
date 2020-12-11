package top.soft1010.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangjifu on 19/11/18.
 */
public class FileUtil {


    public static File createFile(String path,String fileName) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        return new File(file.getParent() + File.separator + fileName);

    }

    public static boolean reName(String path, String newname) {//文件重命名
        //Scanner scanner=new Scanner(System.in);
        File file = new File(path);
        if (file.exists()) {
            File newfile = new File(file.getParent() + File.separator + newname);//创建新名字的抽象文件
            if (file.renameTo(newfile)) {
                System.out.println("重命名成功！");
                return true;
            } else {
                System.out.println("重命名失败！新文件名已存在");
                return false;
            }
        } else {
            System.out.println("重命名文件不存在！");
            return false;
        }
    }


}
