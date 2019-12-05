package jdk.thread.deadLock;

public class loopTest {

	public static void main(String[] args) {
		String tack;
		String flag;
		flag = tack = "hello";
		for (int i = 0; i < 10; i++) System.out.println(flag + i);
		System.out.println("hello");
	}
}
