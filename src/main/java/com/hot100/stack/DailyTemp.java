package com.hot100.stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 2024.12.17 每日温度
 * https://leetcode.cn/problems/daily-temperatures/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] re = new int[temperatures.length];
        Arrays.fill(re, 0);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                re[index] = i - index;
            }
            stack.push(i);
        }
        return re;
    }
}
