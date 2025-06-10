package com.lc150.数组字符串;

public class lc169 {
    public int majorityElement(int[] nums) {
        // 摩尔投票，难点在O(1)空间复杂度上
        int boyer = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            count += nums[i] == boyer ? 1 : -1;
            if (count == 0){
                count = 1;
                boyer = nums[i];
            }
        }
        return boyer;
    }
}
