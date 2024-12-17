package com.hot100.matrix;

/**
 * 2024.12.09 旋转图像
 * https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-100-liked
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        //先沿对角线交换
        for (int i = 0; i < row - 1; i++){
            for (int j = i; j < col; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //左右交换
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col - j - 1];
                matrix[i][col - j - 1] = temp;
            }
        }
        return;
    }
}
