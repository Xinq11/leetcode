package com.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024.12.09 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/?envType=study-plan-v2&envId=top-100-liked
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        List<Integer> re = new ArrayList<>();
        while (left <= right && top <= bottom){
            //从左到右
            for (int i = left; i <= right; i++){
                re.add(matrix[top][i]);
            }
            //从上到下
            for (int j = top + 1; j <= bottom; j++){
                re.add(matrix[j][right]);
            }
            if (left < right && top < bottom){
                //从右到左
                for (int i = right - 1; i > left; i--){
                    re.add(matrix[bottom][i]);
                }
                //从下到上
                for (int j = bottom; j > top; j--){
                    re.add(matrix[j][left]);
                }
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        return re;
    }
}
