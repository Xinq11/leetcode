package com.lc150.数组字符串;

public class lc14 {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            int j = 0;
            while (j < strs.length) {
                if (strs[j].charAt(i) != c)
                    return res.toString();
                j++;
            }
            res.append(c);
        }
        return res.toString();
    }
}
