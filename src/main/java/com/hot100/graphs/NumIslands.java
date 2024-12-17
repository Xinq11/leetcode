package com.hot100.graphs;

/**
 * 2024.12.10 岛屿问题 经典永不过时～ 当时面元戎启行 二面的题
 * https://leetcode.cn/problems/number-of-islands/?envType=study-plan-v2&envId=top-100-liked
 * 同样的 一个dfs的 放在了图论里？ 真的搞不懂力扣怎么分的组
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
