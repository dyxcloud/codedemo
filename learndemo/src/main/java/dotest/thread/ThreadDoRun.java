package dotest.thread;

public class ThreadDoRun {

	public static void main(String[] args) {
		Thread th = new Thread(() -> System.out.println("do Run..."));
		th.start();
	}
}
