package com.hot100.slidingWindows;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024.12.05 滑动窗口 找到字符串中的所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 * 还是左边界的移动
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int l = 0, n = s.length();
        int[] cnt = new int[26];
        for (char c : p.toCharArray()){
            cnt[c - 'a']++;
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int r = 0; r < n; r++) {
            int index = s.charAt(r) - 'a';
            cnt[index]--;
            while (cnt[index] < 0){
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            if (r - l + 1 == p.length()){
                res.add(l);
            }
        }
        return res;
    }
}
