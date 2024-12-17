package com.hot100.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 2024.12.16 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/?envType=study-plan-v2&envId=top-100-liked
 */
public class ValidBrackets {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.get(c) != null) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                Character p = stack.pop();
                if (map.get(p) != c) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
