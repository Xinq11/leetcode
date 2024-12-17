package com.hot100.search;

/**
 * 2024.12.13 寻找旋转排序数据中的最小值
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SearchSpinMin {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= nums[0]) {
                l++;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}
