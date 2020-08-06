package jdk.继承;

/**
 * 单例模式demo,使用双重校验锁实现
 *
 * @author DongYunxiang
 * @create 2018-12-12
 **/
public class SingletonDclDemo {

    private static volatile SingletonDclDemo instance;

    public static SingletonDclDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDclDemo.class) {
                if (instance == null) {
                    instance = new SingletonDclDemo();
                }
            }
        }
        return instance;
    }
}
