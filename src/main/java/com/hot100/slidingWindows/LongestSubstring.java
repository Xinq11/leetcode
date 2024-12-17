package com.hot100.slidingWindows;

import java.util.HashMap;
import java.util.Map;
/**
 * 滑动窗口的核心要点：
 *
 * 1.维护一个有条件的滑动窗口；
 *
 * 2.右端点右移，导致窗口扩大，是不满足条件的罪魁祸首；
 *
 * 3.左端点右移目的是为了缩小窗口，重新满足条件
 *
 * 滑动窗口和双指针是分不开的，是同一种思考方式，只不过滑动窗口会比普通的双指针多维护一个有条件的数据存储
 *
 *
 * 刷完一遍hot100后 可以按照这个题单刷https://leetcode.cn/circle/discuss/0viNMK/
 */

/**
 * 2024.12.05 滑动窗口 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 * 重点在于对左边界的判断
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                // 核心 a b c b a e
                l = Math.max(l, map.get(c) + 1);
            }
            map.put(c, i);
            res = Math.max(res, i - l + 1);
        }
        if (map.size() == s.length()) return map.size();
        return res;
    }
}
