package jdk.charset;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CharSetTest {

    @Test
    public void getByteTest() throws IOException {
        System.out.println(new String("你好世界".getBytes("utf-8"),"iso-8859-1"));
    }
}
