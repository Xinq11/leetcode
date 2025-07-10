package com.lc150.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) continue;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
