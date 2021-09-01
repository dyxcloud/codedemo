package tooltest.apitest;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 字符串压缩
 *
 * @author DongYunxiang
 * @date 2020/01/14
 */
public class CompressDemo {

    private String getsourcestr() throws IOException {
        String file = "D:/Download/光晕第六部：科尔协议.txt";
        Path path = Paths.get(file);
        System.out.println("source size:" + Files.size(path));
        StringBuilder stringBuilder = new StringBuilder();
        Files.readAllLines(path).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public byte[] gzipCompress() throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);) {
            gzipOutputStream.write(getsourcestr().getBytes());
            gzipOutputStream.finish();//写入压缩文件的尾部
            return outputStream.toByteArray();
        }
    }

    public String gzipUncompress(byte[] bytes) throws IOException {
        try (GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(bytes));
             BufferedReader reader = new BufferedReader(new InputStreamReader(gzipInputStream));) {
            StringBuilder stringBuilder = new StringBuilder();
            String s;
            while ((s = reader.readLine()) != null) {
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        }
    }

    @Test
    public void testGzip() throws IOException {
        byte[] bytes = gzipCompress();
        System.out.println(bytes.length);
        String s = gzipUncompress(bytes);
        // System.out.println(s.length());
        System.out.println(s);
    }
}
