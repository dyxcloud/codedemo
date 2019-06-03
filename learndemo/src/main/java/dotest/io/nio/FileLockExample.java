package dotest.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author DongYunxiang
 * @create 2019-06-03
 **/
public class FileLockExample {
    private static final String filepath = "D:\\tmp\\filelock.txt";
    private static Random rand = new Random();

    public void lockAndWrite() throws IOException, InterruptedException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filepath, "rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(4);
        int i = 0;
        while (true) {
            System.out.println("Writer try to lock file...");
            FileLock lock = channel.lock(0, 4, false);

            buffer.putInt(0, i);
            buffer.position(0).limit(4);
            System.out.println("buffer is :" + buffer);
            channel.write(buffer, 0);
            channel.force(true);
            buffer.clear();
            System.out.println("Writer write :" + i++);

            lock.release();
            System.out.println("Sleeping...");
            TimeUnit.SECONDS.sleep(rand.nextInt(3));
        }
    }

    public void lockAndRead() throws InterruptedException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filepath, "r");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(4);
        while (true) {
            System.out.println("Reader try to lock file...");
            FileLock lock = channel.lock(0, 4, true);

            buffer.clear();
            channel.read(buffer, 0);
            buffer.flip();
            System.out.println("buffer is:" + buffer);
            int i = buffer.getInt(0);
            System.out.println("Reader read :" + i);

            lock.release();
            System.out.println("Sleeping...");
            TimeUnit.SECONDS.sleep(rand.nextInt(3));
        }
    }
}
