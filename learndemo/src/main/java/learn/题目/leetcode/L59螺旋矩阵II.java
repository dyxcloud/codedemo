package learn.题目.leetcode;

public class L59螺旋矩阵II {

    /**
     * 生成一个蛇形矩阵
     *
     * @param n 矩阵的边长
     * @return 蛇形矩阵的二维数组容器
     */
    public static int[][] generateMatrix(int n) {
        if (n < 1)
            return new int[0][0];
        int[][] arr = new int[n][n];// 以二位数组形式储存xy坐标
        int step = 1;// 数字记录
        int x = 0, y = 0;// 记录行进坐标
        while (step <= n * n) {
            while (x < n && arr[y][x] == 0) {
                arr[y][x] = step++;
                x++;
            }
            x--;
            y++;
            while (y < n && arr[y][x] == 0) {
                arr[y][x] = step++;
                y++;
            }
            y--;
            x--;
            while (x >= 0  && arr[y][x] == 0) {
                arr[y][x] = step++;
                x--;
            }
            x++;
            y--;
            while (y >= 0 && arr[y][x] == 0) {
                arr[y][x] = step++;
                y--;
            }
            y++;
            x++;
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
        printSnakeMatrix(generateMatrix(4));
    }
}
