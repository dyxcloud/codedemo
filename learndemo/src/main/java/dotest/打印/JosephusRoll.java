package dotest.打印;

import java.util.LinkedList;
import java.util.List;

public class JosephusRoll {

	/**
	 * 约瑟夫环
	 * @param len 总人数
	 * @param step 自杀计数
	 * @return 以自杀顺序排序的序号列表
	 */
	public static List<Integer> getJosephusArray(int len, int step) {
		LinkedList<Integer> list = new LinkedList<Integer>();//生成带有序号的list
		for (int i = 0; i < len; i++)//填充list
			list.add(i + 1);
		List<Integer> deadList = new LinkedList<Integer>();// 弹出顺序数组
		for (int index = 0, count = 1; index < list.size();) {
			if (count++ % step == 0)
				deadList.add(list.remove(index--));//将弹出的序号为index的人放入deadList，因list长度减1，index-1
			index = (index == list.size() - 1) ? 0 : ++index;//判断index是否是list的最后一位
		}
		return deadList;
	}

	public static void main(String[] args) {
		List<Integer> deadList = getJosephusArray(41, 3);
		System.out.println(deadList);
	}
}
