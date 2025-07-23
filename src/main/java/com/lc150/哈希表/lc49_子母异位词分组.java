package com.lc150.哈希表;

import java.util.*;

public class lc49_子母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(int i = 0; i < strs.length; i++) {
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
        for(String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
