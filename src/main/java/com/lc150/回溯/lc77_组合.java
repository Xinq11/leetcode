package com.lc150.回溯;

import java.util.ArrayList;
import java.util.List;

public class lc77_组合 {
    /**
     * 回溯就是在递归的基础上 做一步回撤（回溯是在递归的基础上，通过“撤销选择”来尝试所有可能的解）
     * def backtrack(state: State, choices: list[choice], res: list[state]):
     *     """回溯算法框架"""
     *     # 判断是否为解
     *     if is_solution(state):
     *         # 记录解
     *         record_solution(state, res)
     *         # 不再继续搜索
     *         return
     *     # 遍历所有选择
     *     for choice in choices:
     *         # 剪枝：判断选择是否合法
     *         if is_valid(state, choice):
     *             # 尝试：做出选择，更新状态
     *             make_choice(state, choice)
     *             backtrack(state, choices, res)
     *             # 回退：撤销选择，恢复到之前的状态
     *             undo_choice(state, choice)
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n; i++) {
            List list = new ArrayList<Integer>();
            list.add(i);
            // 调用递归
            dfs(res, list, n, k, i);
        }
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index + 1; i <= n; i++) {
            list.add(i);
            dfs(res, list, n, k, i);
            list.remove(list.size() - 1);
        }
    }
}
