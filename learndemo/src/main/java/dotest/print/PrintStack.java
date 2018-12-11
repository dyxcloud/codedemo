package dotest.print;

/**
 * 打印当前线程的调用栈信息
 * @author DongYunxiang
 * @create 2018-12-11
 **/
public class PrintStack {

    public static void main(String[] args) {
        PrintStack t = new PrintStack();
        t.m1();
    }

    void m1() {
        m2();
    }

    void m2() {
        m3();
    }

    void m3() {
        printTrack();
    }

    void printTrack() {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if (st == null) {
            System.out.println("无堆栈...");
            return;
        }
        StringBuilder sbf = new StringBuilder();
        for (StackTraceElement e : st) {
            sbf.append(java.text.MessageFormat.format("{0}.{1}() {2}"
                    , e.getClassName()
                    , e.getMethodName()
                    , e.getLineNumber())).append("\r\n");
        }
        System.out.println(sbf.toString());

    }
}
