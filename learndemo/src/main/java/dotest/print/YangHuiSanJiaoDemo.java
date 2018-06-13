package dotest.print;

public class YangHuiSanJiaoDemo {

	/**
	 * 生成杨辉三角
	 * 
	 * @param n
	 *            三角的层数
	 * @return 储存杨辉三角的二维数组
	 * @throws Exception
	 */
	public static int[][] getSanJiao(int n) throws Exception {
		int[][] arr = new int[n][];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[i + 1];
			for (int j = 0; j < arr[i].length; j++) {
				if (j == 0 || j == arr[i].length - 1)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}
		return arr;
	}

	public static void main(String[] args) throws Exception {
		int[][] arr = getSanJiao(10);
		for (int[] is : arr) {
			for (int i : is)
				System.out.print(i + "\t");
			System.out.println();
		}
	}
}
