package dotest.dataDeal;

public class 回文数 {

	public static void main(String[] args) {
		// 打印5位回文数
		// number5();
		// 打印n位回文数
		numberAll(2);
	}

	/*
	 * 打印所有5位的回文数
	 */
	public static void number5() {
		for (int i = 9999; i < 100000; i++) {
			int n1 = i % 10;
			int n2 = i / 10 % 10;
			int n3 = i / 10 / 10 % 10;
			int n4 = i / 10 / 10 / 10 % 10;
			int n5 = i / 10 / 10 / 10 / 10 % 10;
			if (n1 == n5 && n2 == n4 && n1 < n2 && n2 < n3)
				System.out.println(i);
		}
	}

	/*
	 * 打印所有n位以内的回文数(非驼峰!!)
	 */
	public static void numberAll(int n) {
		for (int i = 10; i < Math.pow(10, n); i++) {// 10到10的n次方-1的范围
			int l = String.valueOf(i).length();// 当前数的位数
			int[] di = new int[l];// 储存从个位到最大位的数组
			for (int j = 0; j < l; j++) {// 取得各个位数
				int iCopy = (int) (i / Math.pow(10, j));
				di[j] = iCopy % 10;
			}
			int count = 0, k = 0;// 开始判断,k为所判断的位数
			for (; k < l / 2; k++) {// k从0到中位
				if (di[k] == di[l - 1 - k]) {
					count++;// 如果每次都相等,则k与count相等
				} else {
					count = -1;
					break;
				}
			}
			if (count == k)
				System.out.println(i);
		}
	}
}
