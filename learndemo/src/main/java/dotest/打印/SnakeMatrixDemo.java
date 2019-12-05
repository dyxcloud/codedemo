package dotest.打印;

public class SnakeMatrixDemo {

	/**
	 * 生成一个蛇形矩阵
	 * 
	 * @param l 矩阵的边长
	 * @return 蛇形矩阵的二维数组容器
	 */
	public static int[][] getSnakeMatrix(int l) {
		if (l < 1)
			return new int[0][0];
		int[][] arr = new int[l][l];// 以二位数组形式储存xy坐标
		int step = 1;// 数字记录
		int point = 1;// 蛇形的前进方向，取值1,2,3,4
		int end = l * l;// 矩阵中的最大值
		int x = 0, y = 0;// 记录行进坐标
		l--;
		while (step <= end) {
			arr[y][x] = step;
			switch (point) {
			case 1:
				if (x + 1 <= l && arr[y][x + 1] == 0)
					x++;
				else {
					point++;
					y++;
				}
				break;
			case 2:
				if (y + 1 <= l && arr[y + 1][x] == 0)
					y++;
				else {
					point++;
					x--;
				}
				break;
			case 3:
				if (x - 1 >= 0 && arr[y][x - 1] == 0)
					x--;
				else {
					point++;
					y--;
				}
				break;
			case 4:
				if (y - 1 >= 0 && arr[y - 1][x] == 0)
					y--;
				else {
					point = 1;
					x++;
				}
				break;
			}
			step++;
		}
		return arr;
	}

	public static void printSnakeMatrix(int[][] arr) {
		for (int[] is : arr) {
			for (int i : is)
				System.out.print(i + "\t");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printSnakeMatrix(getSnakeMatrix(4));
	}
}
