package com.lc150.数组字符串;

public class lc28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int index = 0;
            while (index < needle.length()) {
                char a = haystack.charAt(i + index);
                char b = needle.charAt(index);
                if (a != b) break;
                index++;
            }
            if (index == needle.length()) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        lc28 lc28 = new lc28();
        lc28.strStr("mississippi", "issip");
    }
}
