package jdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Gzip {

    public static final String GZIP_ENCODE_UTF_8 = "UTF-8";
    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";
    public static String charset = GZIP_ENCODE_ISO_8859_1;

    // 压缩
    public static String compress(String str) throws Exception {
        if (str == null || str.length() == 0)
            return str;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             GZIPOutputStream gzip = new GZIPOutputStream(out)) {
            gzip.write(str.getBytes());
            gzip.finish();
            return out.toString(charset);
        }
    }

    // 解压缩
    public static String uncompress(String str) throws Exception {
        if (str == null || str.length() == 0)
            return str;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes(charset));
             GZIPInputStream gunzip = new GZIPInputStream(in)) {
            byte[] buffer = new byte[1024];
            int n;
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        String s = "aaaaaaaaaaaaaaaaHelloworld你好世界烫烫烫锟斤拷aaaaaaaaaaaaaaaaqweqweqweaaaaaaaaaaaa";
        System.out.println("字符串长度："+s.length());
        String compress = compress(s);
        System.out.println("压缩后：："+compress.length());
        System.out.println("压缩后：："+compress);
        String result = uncompress(compress);
        System.out.println("解压后："+result.length());
        System.out.println("解压后："+result);

    }

}
