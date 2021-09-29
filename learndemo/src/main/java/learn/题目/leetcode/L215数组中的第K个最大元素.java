package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.function.ToIntBiFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L215数组中的第K个最大元素 {

    /**
     * 优先队列(topK 最小堆)
     */
    public int findKthLargest0(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1);
        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * topK 最小堆
     */
    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        System.arraycopy(nums, 0, heap, 0, k);
        buildMinHeap(heap);
        for (int i = k; i < nums.length; i++) {
            if (heap[0] < nums[i]) {
                heap[0] = nums[i];
                minHeapify(heap, k, 0);
            }
        }
        return heap[0];
    }

    private void minHeapify(int[] heap, int size, int rootIndex) {
        if (rootIndex >= size) return;
        int l = rootIndex * 2 + 1;
        int r = rootIndex * 2 + 2;
        int min = rootIndex;
        if (l < size && heap[l] < heap[min]) {
            min = l;
        }
        if (r < size && heap[r] < heap[min]) {
            min = r;
        }
        if (min != rootIndex) {
            swap(heap, rootIndex, min);
            minHeapify(heap, size, min);
        }
    }

    private void buildMinHeap(int[] heap) {
        for (int i = heap.length / 2; i >= 0; i--) {
            minHeapify(heap, heap.length, i);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    @Test
    public void tt() {
        ToIntBiFunction<int[], Integer> func = this::findKthLargest;
        Assertions.assertEquals(5, func.applyAsInt(new int[]{3, 2, 1, 5, 6, 4}, 2));
        Assertions.assertEquals(4, func.applyAsInt(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
