package com.hot100.subString;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2024.12.07 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&envId=top-100-liked
 * 暴力解法就是双层遍历
 * 拆解这个问题，本质上是要优化内层的遍历，外层的遍历避免不了
 * 那内层遍历的本质是什么呢？ 就是要找这个窗口内的最大值，但其实滑动的时候 每次只滑1个距离，也就是说只会淘汰掉窗口最左边的，同时加入一个数，那就么有必要每次都遍历
 * 需要一个数据结构来保存中间值， 这个中间值 指什么？ 指的是你当前窗口内的最大值 和第二大的值，能够保证最大值最划走之后 不用遍历去找（最大值可能是最左边的元素）。
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
         * 暴力解法
         * if (k == 1) return nums;
         *         List<Integer> res = new ArrayList<Integer>();
         *         for (int i = 0; i < nums.length - k + 1; i++) {
         *             int maxNum = nums[i];
         *             int range = Math.min(i + k, nums.length);
         *             for(int j = i; j < range; j++) {
         *                 maxNum = Math.max(maxNum, nums[j]);
         *             }
         *             res.add(maxNum);
         *         }
         *         int[] ints = new int[res.size()];
         *         for(int i = 0; i < res.size(); i++) {
         *             ints[i] = res.get(i);
         *         }
         *         return ints;
         */
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                // 移除最左边的元素
                deque.removeFirst();
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
        /**
         * 从队列尾部取数
         * if(nums.length == 0 || k == 0) return new int[0];
         *         Deque<Integer> deque = new LinkedList<>();
         *         int[] res = new int[nums.length - k + 1];
         *         for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
         *             // 删除 deque 中对应的 nums[i-1]
         *             if(i > 0 && deque.peekLast() == nums[i - 1])
         *                 deque.removeLast();
         *             // 保持 deque 递减
         *             // 要保证栈里 第一个是最大的，同时还要保证第二大也在栈里, 从队列的那边插入 那边删除 都是一样的
         *             while(!deque.isEmpty() && deque.peekFirst() < nums[j])
         *                 deque.removeFirst();
         *             deque.addFirst(nums[j]);
         *             // 记录窗口最大值
         *             if(i >= 0)
         *                 res[i] = deque.peekLast();
         *         }
         *         return res;
         */
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
