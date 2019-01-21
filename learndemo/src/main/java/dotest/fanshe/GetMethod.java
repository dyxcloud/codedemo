package dotest.fanshe;

import java.lang.reflect.Method;

public class GetMethod {

	public static void doArray(int[] arr) {
		System.out.println("geted array method");
	}
	
	public static void doArraylong(int...a) {
		System.out.println("geted doArraylong method");
	}
	
	public static void main(String[] args) throws Exception {
		Method method = GetMethod.class.getMethod("doArraylong", int[].class);
		int[] s=null;
		method.invoke(GetMethod.class, s);
	}
}
