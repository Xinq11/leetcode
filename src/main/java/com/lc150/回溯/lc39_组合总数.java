package com.lc150.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc39_组合总数 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target)
                break;
            List<Integer> list = new ArrayList<Integer>();
            list.add(candidates[i]);
            int sum = candidates[i];
            dfs(list, target, candidates, sum, i);
        }
        return res;

    }

    public void dfs(List<Integer> list, int target, int[] candidates, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (sum > target)
            return;
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            dfs(list, target, candidates, sum, i);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
