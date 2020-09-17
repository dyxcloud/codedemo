package jdk.thread;

import java.util.concurrent.TimeUnit;

public class VolatileTest {

    static class test implements Runnable{
        private boolean flag = true;
        int c;
        @Override
        public void run() {
            while (flag){
                int a=1,b=1;
                c=a+b;
            }
            System.out.println("end");
        }
        public void change(){
            flag = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test t = new test();
        Thread thr = new Thread(t);
        thr.start();
        TimeUnit.SECONDS.sleep(1);
        t.change();
        System.out.println("over");
    }

}
