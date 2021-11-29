package learn.题目.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("NonAsciiCharacters")
public class 探马1 {

    @Test
    public void t1() {
        ArrayList<String> data = new ArrayList<>();
        data.add("qweqw123qwe");
        data.add("qweqw123qwwwwe");
        data.add("qweqw123qwerrr");
        data.add("qweqw135qwe");

        HashSet<String> nums = new HashSet<>();
        String reg = "(?<=[a-zA-Z])*\\d+(?=[a-zA-Z])*";
        Pattern p = Pattern.compile(reg);
        for (int i = data.size() - 1; i >= 0; i--) {
            String s = data.get(i);
            Matcher matcher = p.matcher(s);
            matcher.find();
            String group = matcher.group();
            if (nums.contains(group)) {
                data.remove(i);
            } else {
                nums.add(group);
            }
        }
        System.out.println(data);
        System.out.println(nums);
    }

    static class DepartMent {
        private Long id;
        private String name;
        private List<DepartMent> children;

        public DepartMent(int id, String name, List<DepartMent> children) {
            this.id = (long) id;
            this.name = name;
            this.children = children;
        }
    }

    List<Long> t2Result;

    @Test
    public void t2() {
        t2Result = new ArrayList<>();
        String name = "语文";
        /*new DepartMent(1,"学校", Arrays.asList(
                new DepartMent(2,"一年级",Arrays.asList(
                        new DepartMent(5,"一年级",null)
                        ,new DepartMent(6,"一年级",null)
                ))
                ,new DepartMent(3,"二年级",null)
                ,new DepartMent(4,"三年级",null)
        ));*/
        walk(null, name);
    }

    private void walk(DepartMent dep, String target) {
        if (dep == null) return;
        if (target.equals(dep.name)) {
            t2Result.add(dep.id);
        }
        if (dep.children != null && !dep.children.isEmpty()) {
            dep.children.forEach(ch -> walk(ch, target));
        }
    }

    @Test
    public void t3() throws InterruptedException {

        ReentrantLock la = new ReentrantLock();
        Condition ca = la.newCondition();
        Condition cb = la.newCondition();
        Condition cc = la.newCondition();
        Runnable a = () -> {
            for (int i = 0; i < 10; i++) {
                la.lock();
                try {
                    System.out.println("A");
                    cb.signal();
                    ca.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    la.unlock();
                }
            }
        };
        Runnable b = () -> {
            for (int i = 0; i < 10; i++) {
                la.lock();
                try {
                    System.out.println("B");
                    cc.signal();
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    la.unlock();
                }
            }
        };
        Runnable c = () -> {
            for (int i = 0; i < 10; i++) {
                la.lock();
                try {
                    System.out.println("C");
                    ca.signal();
                    cc.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    la.unlock();
                }
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(a);
        TimeUnit.SECONDS.sleep(1);
        pool.submit(b);
        TimeUnit.SECONDS.sleep(1);
        pool.submit(c);
        pool.shutdown();
    }

    @Test
    public void t4() {
        int[] a1 = {1, 3, 4, 5, 6, 78};
        int[] a2 = {1, 5, 7, 89, 111};
        int[] a3 = {1, 33, 556, 777};
        int[] a4 = {999};

        int[][] data = {a1, a2, a3, a4};

        //构建堆
        int[] heap = new int[10];
        for (int i = 0; i < 10; i++) {
            heap[i] = Integer.MIN_VALUE;
        }
        //每个数组压入前10
        for (int[] arr : data) {
            for (int i = 0; i < arr.length && i < 10; i++) {
                int test = arr[arr.length - 1 - i];
                // System.out.println("test:"+test);
                if (heap[0] < test) {
                    heap[0] = test;
                    fixHeap(heap, 0, 10);
                    System.out.println(Arrays.toString(heap));
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(heap));
        //排序
        for (int i = heap.length - 1; i >= 0; i--) {
            swap(heap, 0, i);
            fixHeap(heap, 0, i);
        }
        System.out.println(Arrays.toString(heap));
    }

    /**
     * 最小堆
     */
    private void fixHeap(int[] heap, int rootIndex, int end) {
        if (rootIndex >= end) return;
        int min = rootIndex;
        int l = rootIndex * 2 + 1;
        int r = rootIndex * 2 + 2;
        if (l < end && heap[l] < heap[min]) {
            min = l;
        }
        if (r < end && heap[r] < heap[min]) {
            min = r;
        }
        if (min != rootIndex) {
            swap(heap, min, rootIndex);
            fixHeap(heap, min, end);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }


}
