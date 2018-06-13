package dotest.other;

import java.util.Arrays;

public class ParamTest {

	public static void doSomeThing(int[] arr) { 
		arr[0]=1111;
	}
	
	
	public static void main(String[] args) {
		int[] arr0 = {1,2,3};
		System.out.println(Arrays.toString(arr0));
		doSomeThing(arr0);
		System.out.println(Arrays.toString(arr0));
	}
}
