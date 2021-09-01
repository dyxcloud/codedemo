package learn.题目.other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public class 和式组合数列 {

	/**
	 * 给定一个正整数,列出可能的数列其相加和为此整数
	 * @date 2017年12月17日
	 */
	ArrayList<List<Integer>> getNumList(int target) {
		ArrayList<List<Integer>> list = new ArrayList<>();
		if (target <= 0) {
			list.add(new ArrayList<>());
			return list;
		} else if (target == 1) {
			list.add(Collections.singletonList(1));
			return list;
		}
		for (int i = target; i > 0; i--) {
			ArrayList<List<Integer>> numList = getNumList(target - i);
            for (List<Integer> aNumList : numList) {
                ArrayList<Integer> startList = new ArrayList<>();
                startList.add(i);
                if (aNumList.size() != 0 && aNumList.get(0) > i)
                    continue;
                startList.addAll(aNumList);
                list.add(startList);
            }
		}
		return list;
	}
	@Test
    public void testget(){
	    getNumList(10).forEach(System.out::println);
    }
}
