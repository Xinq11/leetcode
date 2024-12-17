package com.daily.Dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2024.12.01 N皇后 思路是 全排列问题，但是要限制位置
 * https://leetcode.cn/problems/n-queens/?envType=daily-question&envId=2024-12-01
 */
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n * 2 - 1];
        boolean[] diag2 = new boolean[n * 2 - 1];
        dfs(0, queens, col, diag1, diag2, res);
        return res;
    }

    public void dfs(int r, int[] queens, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> res) {
        int n = col.length;
        if (r == n) {
            List<String> board = new ArrayList<>(n); // 预分配空间
            for (int c : queens) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board.add(new String(row));
            }
            res.add(board);
            return;
        }
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            //int rc = r - c + n - 1;
            if (!col[c] && !diag1[r + c] && !diag2[rc]) {
                queens[r] = c;
                col[c] = diag1[r + c] = diag2[rc] = true;
                dfs(r + 1, queens, col, diag1, diag2, res);
                col[c] = diag1[r + c] = diag2[rc] = false;
            }
        }
    }
}
