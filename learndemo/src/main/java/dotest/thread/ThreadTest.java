package dotest.thread;

public class ThreadTest {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {}
			}
		}).start();
		
		
	}
}
