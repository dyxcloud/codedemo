package dotest.thread.ProducerCunsumer;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    // 用于标记两个线程的状态, 省去主动获取线程状态的麻烦
    volatile Thread.State consumerState = Thread.State.NEW;
    volatile Thread.State producerState = Thread.State.NEW;

    final int queueSize = 10;//队列长度
    volatile Stack<Integer> queue = new Stack<>();

    ReentrantLock consumeLock = new ReentrantLock();
    ReentrantLock produceLock = new ReentrantLock();
    Condition pFull = produceLock.newCondition();//生产者控制器
    Condition cEmpty = consumeLock.newCondition();//消费者控制器

    Runnable consumer = () -> {
        while (true) {
            consumeLock.lock();
            while (queue.isEmpty()) {//队列空, 消费者等待
                try {
                    System.out.println("c: 等待数据");
                    consumerState = Thread.State.WAITING;
                    cEmpty.await();
                } catch (InterruptedException e) { e.printStackTrace();}
            }
            consumerState = Thread.State.RUNNABLE;
            Integer poll = queue.pop();
            System.out.println("c: 获取到[" + poll + "], 剩余元素: " + queue.size());
            if(producerState==Thread.State.WAITING){
                produceLock.lock();
                pFull.signal();
                produceLock.unlock();
            }
            consumeLock.unlock();
        }
    };

    Runnable producer = () -> {
        while(true){
            produceLock.lock();
            while(queue.size() == queueSize) {
                try {
                    System.out.println("p: 等待空间");
                    producerState = Thread.State.WAITING;
                    pFull.await();
                } catch (InterruptedException e) {e.printStackTrace(); }
            }
            producerState = Thread.State.RUNNABLE;
            queue.push(new Random().nextInt());
            System.out.println("p: 插入元素, 剩余空间: "+(queueSize-queue.size()));
            if(consumerState==Thread.State.WAITING){
                consumeLock.lock();
                cEmpty.signal();
                consumeLock.unlock();
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
        while(consumer.getState()!= Thread.State.WAITING || producer.getState()!= Thread.State.WAITING){
            Thread.sleep(500);
        }
        // TODO 两个线程同时进入Wait状态
        System.out.println("opps : "+consumer.getState()+".."+producer.getState());
        System.exit(0);
    }
}
