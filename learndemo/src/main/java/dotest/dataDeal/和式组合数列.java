package dotest.dataDeal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public class 和式组合数列 {

	/**
	 * 给定一个正整数,列出可能的数列其相加和为此整数
	 * @date 2017年12月17日
	 */
	public ArrayList<List<Integer>> getNumList(int target) {
		ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
		if (target <= 0) {
			list.add(new ArrayList<Integer>());
			return list;
		} else if (target == 1) {
			list.add(Arrays.asList(new Integer[] { 1 }));
			return list;
		}
		for (int i = target; i > 0; i--) {
			ArrayList<List<Integer>> numList = getNumList(target - i);
			for (int k = 0; k < numList.size(); k++) {
				ArrayList<Integer> startList = new ArrayList<Integer>();
				startList.add(i);
				List<Integer> endList = numList.get(k);
				if (endList.size() != 0 && endList.get(0) > i)
					continue;
				startList.addAll(endList);
				list.add(startList);
			}
		}
		return list;
	}
	
	
	public static double getPi(int n) {
		double c = n*Math.tan(2*Math.PI/n);
		return c/2;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(getPi(999999));
	}
}
