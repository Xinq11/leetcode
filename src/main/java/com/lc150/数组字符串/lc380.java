package com.lc150.数组字符串;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class lc380 {
    /**
     * hashmap + 数组， 用map保存val和在数组中的index，getRandom直接对数组有效长度内位置随机
     */
    Map<Integer, Integer> map;
    int index;
    int[] nums;
    Random random;

    public lc380() {
        map = new HashMap<Integer, Integer>();
        index = -1;
        nums = new int[200010];
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        nums[++index] = val;
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.remove(val);
        /**
         * 如果移除的元素，正好处在数组的最后一位，则无需更新map，因为已经呗remove了，但如果不是，则需要更新数组的最后一位 到 被移除的元素的位置上
         */
        if (loc != index) map.put(nums[index], loc);
        nums[loc] = nums[index--];
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(index + 1)];
    }
}
