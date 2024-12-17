package com.daily.Dec;

/**
 * 2024.12.03 检查棋盘方格颜色是否相同 思路是 找规律 没啥意思 复习复习String的api
 *  * https://leetcode.cn/problems/check-if-two-chessboard-squares-have-the-same-color/description/?envType=daily-question&envId=2024-12-03
 */
public class CheckTwoChessboards {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        if (((coordinate1.charAt(0) - 'a' + 1) % 2 == (coordinate1.charAt(1) % 2)) == ((coordinate2.charAt(0) - 'a' + 1) % 2 == (coordinate2.charAt(1) % 2))) {
            return true;
        }
        return false;
    }
}
