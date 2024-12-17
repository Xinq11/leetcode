package com.hot100.doublePoint;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 2024.12.05 hot 100 双指针 接雨水 抽象 用了单调栈
 * https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-100-liked
 */
public class RainWater {
    public int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int water = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int r = 0; r < height.length; r++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[r]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int l = stack.peek();
                int lHeight = height[l];
                int rHeight = height[r];
                int bottomHeight = height[bottom];
                water += (r - l - 1) * (Math.min(lHeight, rHeight) - bottomHeight);
            }
            stack.push(r);
        }
        return water;
    }

    public int trap2(int[] walls) {
        if (walls == null || walls.length <= 2) {
            return 0;
        }

        // 思路：
        // 单调不增栈，walls元素作为右墙依次入栈
        // 出现入栈元素（右墙）比栈顶大时，说明在右墙左侧形成了低洼处，低洼处出栈并结算该低洼处能接的雨水

        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for (int right = 0; right < walls.length; right++) {
            // 栈不为空，且当前元素（右墙）比栈顶（右墙的左侧）大：说明形成低洼处了
            while (!stack.isEmpty() && walls[right] > walls[stack.peek()]) {
                // 低洼处弹出，尝试结算此低洼处能积攒的雨水
                int bottom = stack.pop();
                // 看看栈里还有没有东西（左墙是否存在）
                // 有右墙+有低洼+没有左墙=白搭
                if (stack.isEmpty()) {
                    break;
                }

                // 左墙位置以及左墙、右墙、低洼处的高度
                int left = stack.peek();
                int leftHeight = walls[left];
                int rightHeight = walls[right];
                int bottomHeight = walls[bottom];

                // 能积攒的水=(右墙位置-左墙位置-1) * (min(右墙高度, 左墙高度)-低洼处高度)
                water += (right - left - 1) * (Math.min(leftHeight, rightHeight) - bottomHeight);
            }

            // 上面的pop循环结束后再push，保证stack是单调不增
            stack.push(right);
        }

        return water;
    }

}
