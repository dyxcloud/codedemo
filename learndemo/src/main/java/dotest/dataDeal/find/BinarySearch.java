package dotest.dataDeal.find;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = newArrays0ToN(9999999);// 生成一个0到n的顺序数组

		// int index=search(arr, 5645789);//遍历查找
		int index = binarySearch(arr, 5645789);// 二分查找
		// int index = binarySearchByRecursion(arr, 5645789, 0, arr.length-1);//
		// 递归二分

		if (index > -1)
			System.out.println("所在位置为:" + index);
		else
			System.out.println("数组中没有该元素!");
	}

	/*
	 * 普通二分法查找有序数组中des所在的索引位置
	 */
	public static int binarySearch(int[] arr, int des) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (des > arr[mid]) {
				low = mid + 1;
			} else if (des < arr[mid]) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/*
	 * 递归二分法查找有序数组中des所在的索引位置
	 */
	public static int binarySearchByRecursion(int[] arr, int des, int low, int high) {
		int mid = (low + high) / 2;
		if (low > high || des > arr[high] || des < arr[low]) {
			return -1;
		}
		if (des > arr[mid]) {
			return binarySearchByRecursion(arr, des, mid + 1, high);
		} else if (des < arr[mid]) {
			return binarySearchByRecursion(arr, des, low, mid - 1);
		} else {
			return mid;
		}
	}

	/*
	 * 遍历数组查找des的下标索引
	 */
	public static int search(int[] arr, int des) {
		for (int i = 0; i < arr.length; i++) {
			if (des == arr[i])
				return i;
		}
		return -1;
	}

	/*
	 * 生成0到n的正整数数组
	 */
	public static int[] newArrays0ToN(int n) {
		int[] arr = new int[n + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		return arr;
	}

}
