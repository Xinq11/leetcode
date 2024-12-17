package com.hot100.doublePoint;

/**
 * 2024.12.04 hot 100 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while(l < r) {
            int v =  (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, v);
            if (height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
