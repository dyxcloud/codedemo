package dotest.dataDeal;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NumberConverter {

	/**
	 * 数字转为汉字写法
	 * 
	 * @param n
	 * @return
	 */
	public static String numberConvert(int n) {
		String[] dic = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		String[] dic1 = { "", "十" };
		String nStr = String.valueOf(n);
		String numStr = "";
		for (int j = 0, i = nStr.length() - 1; i >= 0; i--, j++) {
			numStr = dic[nStr.charAt(i) - 48] + dic1[j] + numStr;
		}
		return numStr;
	}

	/**
	 * 找map中最大value对应的key
	 * 
	 * @param map
	 * @return
	 */
	public static Integer getKeyOfMaxValue(Map<Integer, Integer> map) {
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		LinkedList<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(entrySet);
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				int i1 = o1.getValue(), i2 = o2.getValue();
				return (i1 > i2) ? 1 : ((i1 == i2) ? 0 : -1);
			}
		});
		return list.getLast().getKey();
	}

	/**
	 * 判断是否是回文字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isHuiWen(String str, int start, int end) {
		if ((start - end) == 1 || start == end)
			return str.charAt(start) == str.charAt(end);
		return (str.charAt(start)) == str.charAt(end) && isHuiWen(str, start + 1, end - 1);
	}

	/**
	 * 显示今年的第几天
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public static void getDayOfYear(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
	}

	/**
	 * 字符串中，sub的出现次数
	 * 
	 * @param str
	 * @param sub
	 * @return
	 */
	public static int getTimeOfSubInStr(String str, String sub) {
		if (sub.length() == 0)
			return 0;
		String newStr = str.replace(sub, "");
		return (str.length() - newStr.length()) / (sub.length());
	}

	public static void main(String[] args) {
		// System.out.println(numberConvert(47));

		// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// map.put(1, 100);
		// map.put(2, 101);
		// map.put(3, 102);
		// map.put(4, 103);
		// System.out.println(getKeyOfMaxValue(map));

		// String str = "abaa"; System.out.println(isHuiWen(str, 0, str.length() - 1));

		// getDayOfYear(2017, 1, 1);

//		System.out.println(getTimeOfSubInStr("abcdefgabcc", "ccs"));
		
		String a="hello";
		String b="he"+new String("llo");
		System.out.println(a==b);
	}
}
