package com.hot100.array;

/**
 * 2024.12.08 轮转数据
 * https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-100-liked
 * 脑筋急转弯
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        int n = k % nums.length;
        if (n == 0) return;
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = nums.length - n; i < nums.length; i++){
            res[index] = nums[i];
            index++;
        }
        for (int j = 0; j < nums.length - n; j++) {
            res[index] = nums[j];
            index++;
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }
}
