package jdk.thread.ProducerCunsumer;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ObjectTest {

    public static void main(String[] args) {
        int queueSize = 10;
        PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);
        Runnable consumer = () -> {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        System.out.println("队列空, 等待数据");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer poll = queue.poll();
                    queue.notify();
                    System.out.println("从队列中取出一个元素[" + poll + "], 队列还剩余" + queue.size() + "个元素");
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable producer = () -> {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        System.out.println("队列满, 等待有剩余空间");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(new Random().nextInt());
                    queue.notify();
                    System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
