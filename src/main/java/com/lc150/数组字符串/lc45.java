package com.lc150.数组字符串;

public class lc45 {
    public int jump(int[] nums) {
        int res = 0, curRight = 0, nextRight = 0;
        /**
         * 为什么是到nums.length - 1？
         * 对于刚好最后一个位置是数组最后一位的，会触发i==curRight 进而对结果+1，实则不需要
          */
        for (int i = 0; i < nums.length - 1; i++) {
            nextRight = Math.max(nextRight, i + nums[i]);
            if (i == curRight) {
                curRight = nextRight;
                res++;
            }
        }
        return res;
    }
}
