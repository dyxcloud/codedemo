package jdk.thread.ProducerCunsumer;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private volatile Thread.State ps = Thread.State.NEW;
    private volatile Thread.State cs = Thread.State.NEW;

    private final int queueSize = 10;//队列长度
    private volatile Stack<Integer> queue = new Stack<>();
    private volatile AtomicInteger count = new AtomicInteger(0);

    private ReentrantLock consumeLock = new ReentrantLock();
    private ReentrantLock produceLock = new ReentrantLock();
    private Condition pFull = produceLock.newCondition();//生产者控制器
    private Condition cEmpty = consumeLock.newCondition();//消费者控制器

    private Runnable consumer = () -> {
        while (true) {
            consumeLock.lock();
            if (queue.isEmpty()) {//队列空, 消费者等待
                try {
//                    System.out.println("c: 等待数据");
                    if (queue.isEmpty() && ps != Thread.State.WAITING) {
                        cs = Thread.State.WAITING;
                        if (queue.isEmpty() && ps != Thread.State.WAITING) {
                            cEmpty.await();
                        }
                    } else {
                        if (produceLock.tryLock()) {
                            pFull.signal();
                            produceLock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                cs = Thread.State.RUNNABLE;
                Integer poll = queue.pop();
//                System.out.println("c: 获取到[" + poll + "], 剩余元素: " + queue.size());
                if (produceLock.tryLock()) {
                    pFull.signal();
                    produceLock.unlock();
                }
            }
            consumeLock.unlock();
        }
    };

    private Runnable producer = () -> {
        while (true) {
            produceLock.lock();
            if (queue.size() == queueSize) {
                try {
//                    System.out.println("p: 等待空间");
                    if (queue.size() == queueSize && cs != Thread.State.WAITING) {
                        ps = Thread.State.WAITING;
                        if (queue.size() == queueSize && cs != Thread.State.WAITING) {
                            pFull.await();
                        }
                    } else {
                        if (consumeLock.tryLock()) {
                            cEmpty.signal();
                            consumeLock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                ps = Thread.State.RUNNABLE;
                queue.push(new Random().nextInt());
                count.getAndIncrement();
//                System.out.println("p: 插入元素, 剩余空间: " + (queueSize - queue.size()));
                if (consumeLock.tryLock()) {
                    cEmpty.signal();
                    consumeLock.unlock();
                }
            }
            produceLock.unlock();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ConditionTest t = new ConditionTest();
        Thread consumer = new Thread(t.consumer, "consumer");
        Thread producer = new Thread(t.producer, "producer");
        consumer.start();
        producer.start();
        while (consumer.getState() != Thread.State.WAITING || producer.getState() != Thread.State.WAITING) {
            Thread.sleep(1000);
            System.out.println(t.count);
            System.out.println(consumer.getState() + ".." + producer.getState());
        }
        // 两个线程同时Waiting/blocked , 解决方式:使用多重校验来调用await()
        System.out.println("opps : " + consumer.getState() + ".." + producer.getState());
        System.out.println(t.count);
        System.exit(0);
    }
}
