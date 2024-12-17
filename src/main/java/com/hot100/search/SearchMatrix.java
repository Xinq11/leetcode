package com.hot100.search;

/**
 * 2024.12.12 搜索二维矩阵
 * https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = 0;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] > target) {
                break;
            }
            index = i;
        }
        int l = 0, r = matrix[index].length - 1;
        while (l <= r) {
            int m = (l + r + 1) / 2;
            if (matrix[index][m] == target) {
                return true;
            } else if (matrix[index][m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
