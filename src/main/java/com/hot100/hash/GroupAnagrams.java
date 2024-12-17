package com.hot100.hash;

import java.util.*;

/**
 * 2024.12.02 hot 100 哈希 字母异位词分组 中等
 * https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
 * 两种方式：
 * 1. 对字符串排序，作为哈希表的key
 * 2. 对字符跟a的差值相加，作为哈希表的key
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            // 将字符串转换为字符数组
            char[] chars = strs[i].toCharArray();
            // 对字符数组进行排序
            Arrays.sort(chars);
            // 将排序后的字符数组重新组合成字符串
            String res = new String(chars);
            if (map.get(res) == null) {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(res, list);
            } else {
                List<String> list = map.get(res);
                list.add(strs[i]);
                map.put(res, list);
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
