package com.lc150.数组字符串;

public class lc13 {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer value = symbolValues.get(c);
            if (i < s.length() - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }
}
