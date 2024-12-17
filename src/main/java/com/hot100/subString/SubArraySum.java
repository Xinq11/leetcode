package com.hot100.subString;

import java.util.HashMap;

/**
 * 2024.12.06 和为k的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
 * 转换思路 不要死脑筋
 * 前缀和是什么？ 一般来讲 找n和他前面的数字和 会从n开始往前遍历，暴力解法
 * 前缀和不用遍历，但要转变思路，map里要保存的是 前缀和 也就是 第一个数的和，第一个第二个的和，第一个第二个第三个的和
 * 然后当你要算n到其前面m的数字总和的时候 不需要一个个加过去，用现在0到n的总和 减去 0到m就是
 */
public class SubArraySum {
    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap< >();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(k - nums[i])) {
                count += mp.get(k - nums[i]);
            }
            pre += nums[i];
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        int i = subArraySum.subarraySum(new int[]{6, 5, 7}, 13);
        System.out.println(i);
        int ii = subArraySum.subarraySum2(new int[]{1,2,3}, 3);
        System.out.println(ii);
    }
}
