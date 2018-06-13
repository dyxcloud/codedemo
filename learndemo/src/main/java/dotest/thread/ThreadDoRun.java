package dotest.thread;

public class ThreadDoRun {

	public static void main(String[] args) {
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
			System.out.println("do Run...");	
			}
		});
		
		th.start();
	}
}
