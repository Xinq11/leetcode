package com.hot100.recall;

/**
 * 2024.12.22 单词搜索
 * https://leetcode.cn/problems/word-search/?envType=study-plan-v2&envId=top-100-liked
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, visited, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int r, int c, char[][] board, boolean[][] visited, String word, int index) {
        if (board[r][c] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        visited[r][c] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newr = r + dir[0], newc = c + dir[1];
            if (newr >= 0 && newr < board.length && newc >= 0 && newc < board[0].length) {
                if (!visited[newr][newc]) {
                    boolean flag = dfs(newr, newc, board, visited, word, index + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[r][c] = false;
        return result;
    }
}
