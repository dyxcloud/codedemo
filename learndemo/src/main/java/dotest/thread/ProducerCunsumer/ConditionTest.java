package dotest.thread.ProducerCunsumer;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    // 用于标记两个线程的状态, 省去主动获取线程状态的麻烦
    Thread.State consumerState = Thread.State.NEW;
    Thread.State producerState = Thread.State.NEW;

    int queueSize = 10;//队列长度
    Queue<Integer> queue = new ConcurrentLinkedQueue<>();//并发队列
    ReentrantLock consumeLock = new ReentrantLock();
    ReentrantLock produceLock = new ReentrantLock();
    Condition pFull = produceLock.newCondition();//生产者控制器
    Condition cEmpty = consumeLock.newCondition();//消费者控制器

    Runnable consumer = () -> {
        while (true) {
            consumeLock.lock();
            while (queue.size() == 0) {//队列空, 消费者等待
                System.out.println("c: 等待数据");
                consumerState = Thread.State.WAITING;
                try {
                    cEmpty.await();
                } catch (InterruptedException e) { e.printStackTrace();}
            }
            consumerState = Thread.State.RUNNABLE;
            Integer poll = queue.poll();
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
                System.out.println("p: 等待空间");
                producerState = Thread.State.WAITING;
                try {
                    pFull.await();
                } catch (InterruptedException e) {e.printStackTrace(); }
            }
            producerState = Thread.State.RUNNABLE;
            queue.offer(new Random().nextInt());
            System.out.println("p: 插入元素, 剩余空间: "+(queueSize-queue.size()));
            if(consumerState==Thread.State.WAITING){
                consumeLock.lock();
                cEmpty.signal();
                consumeLock.unlock();
            }
            produceLock.unlock();
        }
    };

    public static void main(String[] args) {
        ConditionTest t = new ConditionTest();
        Thread consumer = new Thread(t.consumer, "consumer");
        Thread producer = new Thread(t.producer, "producer");
        consumer.start();
        producer.start();
        while(consumer.getState()!= Thread.State.WAITING || producer.getState()!= Thread.State.WAITING){

        }
        // TODO 两个线程同时进入Wait状态
        System.out.println("opps");
        System.exit(0);
    }
}
