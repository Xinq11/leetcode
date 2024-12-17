package com.hot100.stack;

import java.util.LinkedList;

/**
 * 2024.12.17 字符串解码
 * https://leetcode.cn/problems/decode-string/?envType=study-plan-v2&envId=top-100-liked
 * 第一遍写的方法有点笨。。 粘一个两年前的
 * public String decodeString(String s) {
 *         StringBuilder res = new StringBuilder();
 *         LinkedList<Integer> numStack = new LinkedList<>();
 *         LinkedList<String> strStack = new LinkedList<>();
 *         int num = 0;
 *         for (int i = 0; i < s.length(); i++){
 *             char c = s.charAt(i);
 *             if (c == '['){
 *                 numStack.push(num);
 *                 strStack.push(res.toString());
 *                 num = 0;
 *                 res = new StringBuilder();
 *             }else if (c == ']'){
 *                 StringBuilder tag = new StringBuilder();
 *                 int n = numStack.pop();
 *                 for(int j = 0; j < n; j++) tag.append(res);
 *                 res = new StringBuilder(strStack.pop() + tag);
 *             }else{
 *                 //判断是数字还是字符
 *                 if (Character.isDigit(c)){
 *                     num = num * 10 + Integer.parseInt(String.valueOf(c));
 *                 }else{
 *                     res.append(String.valueOf(c));
 *                 }
 *
 *             }
 *         }
 *         return res.toString();
 *     }
 */
public class DecodeString {
    public String decodeString(String s) {
        LinkedList<Integer> number = new LinkedList<Integer>();
        LinkedList<String> chars = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == '[') {
                // 将数字入栈 清空sb
                if (sb.length() != 0) {
                    number.push(Integer.valueOf(sb.toString()));
                    sb = new StringBuilder();
                }
                // 将 [ 入栈
                chars.push(c.toString());
            } else if (c == ']') {
                // 将字符出栈
                StringBuilder cs = new StringBuilder();
                while (!chars.isEmpty() && !chars.peek().equals("[")) {
                    cs.insert(0, chars.pop());
                }
                int n = 1;
                // 将数字出栈
                if (!number.isEmpty()) n = number.pop();
                StringBuilder son = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    // 循环
                    son.append(cs);
                }
                // 把 [ 弹出
                if(!chars.isEmpty() && chars.peek().equals("[")) chars.pop();
                StringBuilder newSon = new StringBuilder();
                // 如果 chars 不为空且不为 [ 则需要弹出还存在栈里的字符，和循环后的拼一起再入栈
                while (!chars.isEmpty() && !chars.peek().equals("[")) {
                    newSon.insert(0, chars.pop());
                }
                newSon.append(son);
                if (chars.isEmpty()) {
                    // 直接拼结果
                    res.append(newSon);
                } else {
                    // 再入栈
                    chars.push(newSon.toString());
                }
            } else {
                //sb.append(c);
                chars.push(c.toString());
            }
        }
        StringBuilder tail = new StringBuilder();
        while(!chars.isEmpty()) {
            tail.insert(0, chars.pop());
        }
        res.append(tail);
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String s = decodeString.decodeString("3[a2[c]]");
        System.out.println(s);
    }
}
