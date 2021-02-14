package learn.题目.剑指offer;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("NonAsciiCharacters")
public class Of62圆圈中最后剩下的数字 {

    class Linked {
        // 数数版: 时间复杂度 n*m
        // 优化1: 省略超过size的计数
        public int lastRemaining(int n, int m) {
            int runTimes = 0;
            LinkedList<Integer> list = IntStream.range(0, n).boxed().collect(Collectors.toCollection(LinkedList::new));
            Iterator<Integer> iterator = list.iterator();
            int useM = getUsedM(list.size(), m);//优化1:
            int count = 1;
            for (; ; ) {
                while (iterator.hasNext()) {
                    runTimes++;
                    Integer next = iterator.next();
                    if (count % useM == 0) {
                        iterator.remove();
                        if (list.isEmpty()) {
                            System.out.println("runTimes: " + runTimes);
                            return next;
                        }
                        count = 1;
                        useM = getUsedM(list.size(), m);
                    } else {
                        count++;
                    }
                }
                iterator = list.iterator();
            }
        }

        private int getUsedM(int size, int m) {
            if (size <= 1) {
                return 1;
            }
            if (m <= size) {
                return m;
            }
            int result = m % size;
            if (result == 0) {
                return m;
            }
            return result;
        }
    }

    class Arrayed {
        //使用计算下标随机访问的方式
        public int lastRemaining(int n, int m) {
            ArrayList<Integer> list = IntStream.range(0, n).boxed().collect(Collectors.toCollection(ArrayList::new));
            int index = 0;
            while (n > 1) {
                index = (index + m - 1) % n;
                list.remove(index);//使用System.arraycopy进行数组元素批量复制, 避免for循环来移动元素, 时间复杂度远小于O(n)
                n--;
            }
            return list.get(0);
        }
    }


    @Test
    public void testLast() {
        Arrayed arrayed = new Arrayed();
        TestCase.assertEquals(3, arrayed.lastRemaining(5, 3));
        TestCase.assertEquals(2, arrayed.lastRemaining(10, 17));
        TestCase.assertEquals(64165, arrayed.lastRemaining(70866, 116922));
    }

    /**
     * 约瑟夫环
     *
     * @param len  总人数
     * @param step 自杀计数
     * @return 以自杀顺序排序的序号列表
     */
    public static List<Integer> getJosephusArray(int len, int step) {
        LinkedList<Integer> list = new LinkedList<>();//生成带有序号的list
        for (int i = 0; i < len; i++)//填充list
            list.add(i + 1);
        List<Integer> deadList = new LinkedList<>();// 弹出顺序数组
        for (int index = 0, count = 1; index < list.size(); ) {
            if (count++ % step == 0)
                deadList.add(list.remove(index--));//将弹出的序号为index的人放入deadList，因list长度减1，index-1
            index = (index == list.size() - 1) ? 0 : ++index;//判断index是否是list的最后一位
        }
        return deadList;
    }

    public static void main(String[] args) {
        TestCase.assertEquals(Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 1, 5, 10, 14, 19, 23, 28, 32, 37, 41, 7, 13, 20, 26, 34, 40, 8, 17, 29, 38, 11, 25, 2, 22, 4, 35, 16, 31), getJosephusArray(41, 3));
        TestCase.assertEquals(Arrays.asList(3, 1, 5, 2, 4), getJosephusArray(5, 3));
    }
}
