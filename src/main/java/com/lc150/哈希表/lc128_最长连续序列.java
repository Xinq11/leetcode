package com.lc150.哈希表;

import java.util.HashMap;
import java.util.Map;

public class lc128_最长连续序列 {
    /**
     * 空间换时间
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0);
        }
        int max = 1;
        for (Integer key : map.keySet()) {
            if (map.get(key - 1) == null && map.get(key + 1) != null) {
                int res = 1;
                int tag = key;
                while (map.get(tag + 1) != null) {
                    res += 1;
                    tag += 1;
                }
                max = Math.max(max, res);
            }
        }
        return max;
    }
}
