package com.hot100.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024.12.21 子集
 * https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        List<Integer> list = new ArrayList<Integer>();
        dfs(res,list,nums,0);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int i) {
        if(i == nums.length) return;
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            res.add(new ArrayList(list));
            dfs(res, list, nums, j + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] param = new int[]{1,2,3};
        subsets.subsets(param);
    }
}
