package com.hot100.doublePoint;

/**
 * 2024.12.04 hot 100 进入双指针阶段 移动0 双指针
 * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
 *
 * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 双指针注意一点！
 * 不是只有一个在最左，一个在最右的 才叫双指针
 * 只要是两个指针 指向不同的位置 就算双指针
 */
public class ZeroMove {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        while (r < n) {
            if (nums[r] != 0) {
                int v = nums[l];
                nums[l] = nums[r];
                nums[r] = v;
                l++;
            }
            r++;
        }
    }
}
