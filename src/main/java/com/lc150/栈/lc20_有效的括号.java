package com.lc150.栈;

import java.util.HashMap;
import java.util.LinkedList;

public class lc20_有效的括号 {
    HashMap<Character, Character> map = new HashMap<Character, Character>() {
        {
            put('{', '}');
            put('(', ')');
            put('[', ']');
        }
    };

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
