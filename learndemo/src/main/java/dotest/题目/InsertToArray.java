package dotest.题目;

import java.util.Arrays;

public class InsertToArray {

	/**
	 * 有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
	 * @param arr 原始有序数组
	 * @param num 要插入的数字
	 * @return 新的数组
	 */
	public static int[] insertNumToArray(int[] arr, int num) {
		int len = arr.length;
		int[] arr2 = new int[len + 1];
		int j = 0;// arr2的指针
		int point = arr[len - 1] - arr[0];// 大于0表示升序，小于0表示降序
		boolean flag = true;// true表示未进行插入操作

		if (point == 0 || (point > 0 && num <= arr[0]) || (point < 0 && num >= arr[0])) {
			arr2[0] = num;
			j++;
			flag = false;
		} else if ((point < 0 && num <= arr[len - 1]) || (point > 0 && num >= arr[len - 1])) {
			arr2[len] = num;
			flag = false;
		}
		for (int i = 0; i < len; i++, j++) {
			arr2[j] = arr[i];// 原始数组复制
			// 中部插入判断
			if (flag && (i + 1 < len) && (((num - arr[i]) ^ (arr[i + 1] - num)) >= 0))
				arr2[++j] = num;
		}
		return arr2;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 12, 13, 20, 21, 23, 35, 44 };
		System.out.println(Arrays.toString(insertNumToArray(arr, 34)));
	}
}
