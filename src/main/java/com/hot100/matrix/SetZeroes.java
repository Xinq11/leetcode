package com.hot100.matrix;

/**
 * 2024.12.09 矩阵 矩阵的题真的。。。死记硬背就完了
 * https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int c = matrix[0].length;
        int r = matrix.length;
        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
