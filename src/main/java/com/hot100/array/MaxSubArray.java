package com.hot100.array;

/**
 * 2024.12.08 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&envId=top-100-liked
 * 动态规划  f(i)=max{f(i−1)+nums[i],nums[i]}
 * 力扣这个分组真的很奇怪。。后面打算直接跳过hard 先把middle刷了 然后体系化的学一遍吧
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
