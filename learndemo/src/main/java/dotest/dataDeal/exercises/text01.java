package dotest.dataDeal.exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class text01 {
	public static void main(String[] args) {
		// nizhuan();
		// pingfangshu();
		// lianjieList();
		// getNum(23);
		// printInFrame();
		tran();

	}

	/*
	 * 去除首字母,每个单词后追加ay
	 */
	private static void tran() {
		// TODO Auto-generated method stub
		String str = ("The quick brown fox");
		String[] sts = str.split(" ");
		for (int i = 0; i < sts.length; i++) {
			sts[i] = sts[i].substring(1);// 去除首字母
			String s = String.valueOf(sts[i].charAt(0));
			if (i == 0)
				s = s.toUpperCase();
			sts[i] = s.concat(sts[i].substring(1)).concat("ay");
		}
		for (String string : sts) {
			System.out.print(string + " ");
		}
	}

	/*
	 * 打印数组在矩形框
	 */
	private static void printInFrame() {
		// TODO Auto-generated method stub
		String[] str = { "Hello", "World", "in", "a", "frame" };
		int l = str[0].length();
		for (String string : str) {
			l = Math.max(l, string.length());
		}
		for (int i = 0; i < str.length; i++) {
			str[i] = str[i].concat("*");
			int num = l - str[i].length();
			for (int j = 0; j < num; j++) {
				str[i] = str[i].concat("  ");
			}
		}
		System.out.println("_________________________");
		System.out.print("| 1\t|");
		for (int i = 0; i < l + 2; i++) {
			System.out.print("*");
		}
		System.out.print("\t|\n");
		for (int i = 0; i < str.length; i++) {
			System.out.println("| " + (i + 2) + "\t|*" + str[i] + "\t|");
		}
		System.out.print("| " + (str.length + 2) + "\t|");
		for (int i = 0; i < l + 2; i++) {
			System.out.print("*");
		}
		System.out.print("\t|\n");
		System.out.println("_________________________");
	}

	/*
	 * 写个函数，返回指定数的各位数字的列表
	 */
	public static void getNum(int n) {
		// TODO Auto-generated method stub
		int[] ir = new int[String.valueOf(n).length()];
		for (int i = 0; i < ir.length; i++) {
			int nCopy = (int) (n / (Math.pow(10, i)));
			ir[i] = nCopy % 10;
		}
		for (int i : ir) {
			System.out.println(i + "\t");
		}
	}

	/*
	 * 交替合并两个列表
	 */
	private static void lianjieList() {
		// TODO Auto-generated method stub
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			list1.add(i);
		}
		for (int i = 5; i < 10; i++) {
			list2.add(i);
		}
		System.out.println(list1);
		System.out.println(list2);
		System.out.println("=============");
		// 方法1
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < list1.size(); i++) {
			list.add(list1.get(i));
			list.add(list2.get(i));
		}
		System.out.println(list);
		// 方法2
		for (int i = list2.size() - 1; i >= 0; i--) {
			list1.add(i + 1, list2.get(i));
		}
		System.out.println(list1);
	}

	/*
	 * 完全平方数
	 */
	private static void pingfangshu() {
		// TODO Auto-generated method stub
		ArrayList<Integer> lists = new ArrayList<Integer>();
		Integer[] ars = new Integer[20];
		for (int i = 1; i <= ars.length; i++) {
			ars[i - 1] = i;
		}
		lists.addAll(Arrays.asList(ars));
		System.out.println(lists);
		for (Integer integer : ars) {
			for (int i = 1; i < (Math.sqrt(integer) + 1); i++) {
				if (i * i == integer) {
					System.out.println(integer);
				}
			}
		}
	}

	/*
	 * 数组逆转
	 */
	private static void nizhuan() {
		// TODO Auto-generated method stub
		int[] arrs = new int[20];
		for (int i = 0; i < arrs.length; i++) {
			arrs[i] = i;
		}
		for (int i = 0, j = arrs.length - 1; i < j; i++, j--) {
			int temp = arrs[i];
			arrs[i] = arrs[j];
			arrs[j] = temp;
		}
		for (int i : arrs) {
			System.out.print(i + "\t");
		}
	}

}
