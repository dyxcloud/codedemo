package jdk.io.nio;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author DongYunxiang
 * @create 2019-06-03
 **/
public class ChannelDemo {


    public static void main(String[] args) {
        ReadableByteChannel readableByteChannel = Channels.newChannel(System.in);
        WritableByteChannel writableByteChannel = Channels.newChannel(System.out);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            while (readableByteChannel.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    writableByteChannel.write(buffer);
                }
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFilePosition() {
        final String filepath = "D:\\tmp\\a.txt";
        try {
            //create a file with 26 char a~z
            FileOutputStream fos = new FileOutputStream(filepath);
            StringBuilder sb = new StringBuilder();
            for (char c = 'a'; c <= 'z'; c++) {
                sb.append(c);
            }
            fos.write(sb.toString().getBytes());
            fos.flush();
            fos.close();

            //creat FileChannel
            RandomAccessFile file = new RandomAccessFile(filepath, "rw");
            FileChannel channel = file.getChannel();
            System.out.println("file position in FileChannel is :" + channel.position());
            file.seek(5);
            System.out.println("file position in FileChannel is :" + channel.position());
            channel.position(10);
            System.out.println("file position in RandomAccessFile is :" + file.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
