package com.hot100.search;

/**
 * 2024.12.13 搜索旋转排序数组
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SearchSpin {
    public int search(int[] nums, int target) {
        if (nums[nums.length - 1] > nums[0]) {
            int l = 0, r = nums.length - 1;
            // 找
            int res = searchRes(nums, target, l, r);
            if (nums[res] != target) {
                return -1;
            }
            return res;
        } else {
            int point = searchPoint(nums);
            if (target == nums[point]) {
                return point;
            } else if (target > nums[point] && target <= nums[nums.length - 1]) {
                int l = point + 1, r = nums.length - 1;
                // 找
                int res = searchRes(nums, target, l, r);
                if (nums[res] != target) {
                    return -1;
                }
                return res;
            } else {
                int l = 0, r= point - 1;
                // 找
                int res = searchRes(nums, target, l, r);
                if (nums[res] != target) {
                    return -1;
                }
                return res;
            }
        }
    }

    public int searchPoint(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= nums[0]) {
                l++;
            } else {
                r--;
            }
        }
        return l;
    }


    public int searchRes(int[] nums, int target, int l, int r) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
