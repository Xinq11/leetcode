package com.hot100.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 2024.12.01 hot 100 哈希 两数之和 空间换时间 哈希表
 * https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
