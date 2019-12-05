package dotest.题目;

public class GetASum {

	/**
	 * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
	 * 
	 * @param index
	 *            第n个数
	 * @return 一个数组,索引中：0表示分子,1表示分母,2表示数列和
	 */
	public static double[] getNumArr(int index) {
		if (index < 1)
			return new double[3];
		if (index == 1)
			return new double[] { 2D, 1D, 2D };
		double[] arr = getNumArr(index - 1);
		return new double[] { arr[0] + arr[1], arr[0], arr[2] + (arr[0] + arr[1]) / arr[0] };
	}

	/**
	 * 编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n
	 * @param n
	 * @return
	 */
/*	public static double getASum(int n) {
		if (n <= 0)
			return 0D;
		if (n == 1)
			return 1D;
		if (n == 2)
			return 0.5D;
		return (1D / n) + getASum(n - 2);
	}*/
	
	/**
	 * 海滩上有一堆桃子，五只猴子来分。
	 * 第一只猴子把这堆桃子平均分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
	 * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，
	 * 第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
	 * sum=5n+1
	 */
	public static int getASum(int n) {
		int sum=0;
		if(n==5) {
			sum=0;
		}
		for (int i = 0; i < 5; i++) {
			
		}
		return sum;
	}

	public static void main(String[] args) {
//		double[] arr;
//		for (int i = 1; i < 21; i++) {
//			arr = getNumArr(i);
//			System.out.println(arr[0] + "/" + arr[1] + ">>>>" + arr[2]);
//		}
		
//		System.out.println(getASum(5));
		
		System.out.println("hello World 测试");
	}
}
