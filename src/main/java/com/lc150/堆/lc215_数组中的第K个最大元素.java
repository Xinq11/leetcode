package com.lc150.堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc215_数组中的第K个最大元素 {
    /**
     * 3，2，1，5，6，4
     * <p>
     * 1. 3,2,1,5,6,4 找到最大的 和 -1 (index) 换 4,2,1,5,3,6
     * 2. 4,2,1,5,3   找到最大的 和 -2 (index) 换 4,2,1,3,5,6
     * 3. 4,2,1,3     找到最大的 和 -3 (index) 换 3,2,1,4,5,6
     * 4. 3,2,1       找到最大的 和 -4 (index) 换 1,2,3,4,5,6
     * 5. 1,2         找到最大的 和 -5 (index) 换 1,2,3,4,5,6
     */
    public int findKthLargest(int[] nums, int k) {
        // 从数组尾开始遍历
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            build(nums, i);
            int tag = nums[i];
            nums[i] = nums[0];
            nums[0] = tag;
        }
        return nums[nums.length - k];
    }

    public void build(int[] nums, int size) {
        /**
         *         3(0)
         *   2(1)       1(2)
         * 5(3) 6(4) 4(5)
         *         ->
         *         3(0)
         *   2(1)       4(2)
         * 5(3) 6(4) 1(5)
         * 二叉树 使根节点是最大的
         */
        for (int i = (size + 1) / 2 - 1; i >= 0; i--) {
            int l = i * 2 + 1;
            int r = i * 2 + 2;
            int index = l;
            if (r <= size) {
                index = (nums[l] < nums[r]) ? r : l;
            }
            if (nums[index] > nums[i]) {
                int tag = nums[i];
                nums[i] = nums[index];
                nums[index] = tag;
            }
        }
    }

    /**
     * 或者直接用优先级队列
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆，PriorityQueue 底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        // Java 里没有 heapify ，因此我们逐个将前 k 个元素添加到 minHeap 里
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < len; i++) {
            // 看一眼，不拿出，因为有可能没有必要替换
            Integer topElement = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topElement) {
                // Java 没有 replace()，所以得先 poll() 出来，然后再放回去
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
