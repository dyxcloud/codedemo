package dotest.dataDeal;

import java.util.Comparator;

public class SortDemo {

	/**
	 * 冒泡排序
	 * @author DongYunxiang
	 * @date 2017年12月18日
	 * @param list
	 */
	public <T extends Comparable<T>> void bubbleSort(T[] list) {
		boolean swapped = true;
		for (int i = list.length - 1; i > 0 && swapped; i--) {
			swapped = false;
			for (int j = 0; j < i; j++) {
				if (list[j].compareTo(list[j + 1]) > 0) {
					T temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					swapped = true;
				}
			}
		}
	}

	/**
	 * 冒泡排序,自定义比较器
	 * @author DongYunxiang
	 * @date 2017年12月18日
	 * @param list
	 * @param comp
	 */
	public <T extends Comparable<T>> void bubbleSort(T[] list, Comparator<T> comp) {
		boolean swapped = true;
		for (int i = list.length - 1; i > 0 && swapped; i--) {
			swapped = false;
			for (int j = 0; j < i; j++) {
				if (comp.compare(list[j], list[j + 1]) > 0) {
					T temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					swapped = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
