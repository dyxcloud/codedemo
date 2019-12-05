package jdk.thread;

/**
 * @author DongYunxiang
 * @create 2019-02-11
 **/
public class CASCount {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        normalIncr();
        Thread.sleep(2000);
        System.out.println(count);
    }

    /**
     * 使用普通自增一般count小于200
     */
    public static void normalIncr(){
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //每个线程让count自增100次
                for (int i1 = 0; i1 < 100; i1++) {
                    count++;
                }
            }).start();
        }
    }
}
