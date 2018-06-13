package dotest.dataDeal;

import java.util.ArrayList;
import java.util.Arrays;

public class ListReMove {

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
		/*for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i) == 5)
				list.remove(i);
		}*/
		for (Integer i:list) {
			if (i == 9)
				list.remove(new Integer(9));
		}
		System.out.println(list);
	}
}
