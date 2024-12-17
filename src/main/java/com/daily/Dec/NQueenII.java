package com.daily.Dec;

/**
 * 2024.12.02 N皇后II 偷了个懒 和 N皇后1 一样的解法
 * https://leetcode.cn/problems/n-queens-ii/
 */
public class NQueenII {
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] flag1 = new boolean[2 * n - 1];
        boolean[] flag2 = new boolean[2 * n - 1];
        return dfs(0, n, cols, flag1, flag2);
    }

    public int dfs(int r, int n, boolean[] cols, boolean[] flag1, boolean[] flag2) {
        if (r == n) {
            return 1;
        }
        int res = 0;
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!cols[c] && !flag1[r + c] && !flag2[rc]) {
                cols[c] = flag1[r + c] = flag2[rc] = true;
                res += dfs(r + 1, n, cols, flag1, flag2);
                cols[c] = flag1[r + c] = flag2[rc] = false;
            }
        }
        return res;
    }
}
