package dotest.other;

public class FizzBuzz {

	public static void main(String[] args) {
		for(int i=1;i<101;i++) {
			doTest(i);
		}
	}
	
	public static void doTest(int i) {
		System.out.print("this num is:"+i+">>>>");
		if(i%3==0)
			System.out.print("fizz");
		if(i%5==0)
			System.out.print("buzz");
		System.out.println();
	}
	
}
