package learn.题目.other;

@SuppressWarnings("ALL")
public class 统计字符出现次数 {

	public static void main(String[] args) {
		String s = "======="; // 待统计字符串
		getMostInStr(s);
	}

	/**
	 * 获得字符串中出现次数最多的字符
	 * @param s
	 */
	public static void getMostInStr(String s) {
		char max = 0; // 记录最大字母
        int[] cnt = new int[127]; // 临时计数用的数组
        for (int i = 0; i < s.length(); i++) { // 循环字符以做统计
              char c = s.charAt(i); // 取出单个字母
              max = (++cnt[c] > max) ? c : max; // 计数并检测最大出现次数
        }
        System.out.println (max+">>"+cnt[max]);
	}
}
