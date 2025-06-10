package com.hot100.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024.12.21 全排列
 * https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        List list = new ArrayList<Integer>();
        dfs(list, re, nums);
        return re;
    }
    // dfs
    public void dfs(List<Integer> list, List<List<Integer>> re, int[] nums){
        // 退出条件
        if (list.size() == nums.length){
            re.add(new ArrayList<Integer>(list));
            return;
        }
        // 子循环
        for(int i = 0; i < nums.length; i++){
            if (!list.contains(nums[i])){
                list.add(nums[i]);
                dfs(list, re, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
