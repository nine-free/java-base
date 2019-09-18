package top.soft1010.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by bjzhangjifu on 2019/7/23.
 */
public class ZipTest {

    public static void main(String[] args) throws IOException {

//        ZipFile zipFile = new ZipFile("C:\\Users\\bjzhangjifu\\Desktop\\confirm_letter.zip");
//        ZipFile zipFile = new ZipFile("tmp.zip");
//        Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
//        while (enumeration.hasMoreElements()) {
//            ZipEntry zipEntry = enumeration.nextElement();
//            if (!zipEntry.isDirectory()) {
//                System.out.println(zipEntry.getName());
//            }
//        }
        MathContext mathContext = new MathContext(2);
        BigDecimal bigDecimal = new BigDecimal(1).multiply(new BigDecimal(3)).divide(new BigDecimal(3));
        System.out.println(bigDecimal.doubleValue());
        BigDecimal bigDecimal2 = new BigDecimal(1).divide(new BigDecimal(3),mathContext);
        System.out.println(bigDecimal2.doubleValue());

    }

    private static byte[] getFileBytes(String url) throws IOException {
        URL urlConet = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlConet.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(4 * 1000);
        InputStream inStream = con.getInputStream();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        byte[] data = outStream.toByteArray();
        return data;
    }


}
