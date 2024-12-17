package com.hot100.search;

/**
 * 2024.12.12 搜索插入位置
 * https://leetcode.cn/problems/search-insert-position/?envType=study-plan-v2&envId=top-100-liked
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    private int search(int[] nums, int target, int l, int r){
        int m = (l + r + 1) / 2;
        if (nums[r] < target) return r + 1;
        if (nums[l] > target) return l;
        if (nums[m] > target) {
            return search(nums, target, l, m - 1);
        } else if (nums[m] < target) {
            return search(nums, target, m + 1, r);
        } else {
            return m;
        }
    }
}
