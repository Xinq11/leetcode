package com.lc150.回溯;

import java.util.ArrayList;
import java.util.List;

public class lc46_全排列 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            dfs(nums, i, list);
        }
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            dfs(nums, i, list);
            list.remove(list.size() - 1);
        }
    }
}
