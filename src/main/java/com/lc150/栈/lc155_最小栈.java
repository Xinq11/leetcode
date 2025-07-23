package com.lc150.栈;

import java.util.LinkedList;

public class lc155_最小栈 {
    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;

    public lc155_最小栈() {
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
