package com.hot100.stack;

import java.util.LinkedList;

/**
 * 2024.12.16 最小栈
 * https://leetcode.cn/problems/min-stack/?envType=study-plan-v2&envId=top-100-liked
 */
public class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int v = stack.pop();
        if (!minStack.isEmpty() && minStack.peek().equals(v)){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()){
            return 0;
        }else{
            return minStack.peek();
        }
    }
}
