package learn.题目;

import org.junit.Test;

import java.util.*;

public class text01 {

	/*
	 * 去除首字母,每个单词后追加ay
	 */
	private static void tran() {
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
     * 找map中最大value对应的key
     */
    public static Integer getKeyOfMaxValue(Map<Integer, Integer> map) {
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(entrySet);
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        return list.getLast().getKey();
    }
    @Test
    public void testGetkeyofMaxValue() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 100);
        map.put(2, 101);
        map.put(3, 102);
        map.put(4, 103);
        System.out.println(getKeyOfMaxValue(map));
    }




    /**
     * 字符串中，sub的出现次数
     */
    public static int getTimeOfSubInStr(String str, String sub) {
        if (sub.length() == 0)
            return 0;
        String newStr = str.replace(sub, "");
        return (str.length() - newStr.length()) / (sub.length());
    }
    @Test
    public void testGetTimeOfSubInStr(){
        System.out.println(getTimeOfSubInStr("abcdefgabcc", "ccs"));
    }


}
