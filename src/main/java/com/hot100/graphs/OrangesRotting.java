package com.hot100.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024.12.10 腐烂的橘子 虽然在图论的分类里 确是个bfs
 * https://leetcode.cn/problems/rotting-oranges/submissions/586363834/?envType=study-plan-v2&envId=top-100-liked
 * 好题解
 * https://leetcode.cn/problems/rotting-oranges/solutions/129831/li-qing-si-lu-wei-shi-yao-yong-bfsyi-ji-ru-he-xie-/?envType=study-plan-v2&envId=top-100-liked
 *
 * 顺带复习一下LinkedList的api
 * 队列操作
 * offer(E e): 添加元素到尾部（返回 true）。
 * offerFirst(E e): 添加元素到头部。
 * offerLast(E e): 添加元素到尾部。
 * poll(): 删除并返回头部元素（返回 null 如果为空）。
 * pollFirst() / pollLast(): 删除并返回头部或尾部元素。
 *
 * 堆栈操作
 * push(E e): 将元素添加到头部。
 * pop(): 删除并返回头部元素。
 *
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        LinkedList<List<Integer>> queue = new LinkedList<List<Integer>>();
        int freshOrange = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    freshOrange++;
                } else if (grid[i][j] == 2) {
                    queue.offer(Arrays.asList(i, j));
                }
            }
        }
        int timer = 0;
        while (freshOrange > 0 && !queue.isEmpty()) {
            timer++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                List<Integer> badOrange = queue.poll();
                int badOrangeR = badOrange.get(0);
                int badOrangeC = badOrange.get(1);
                if (badOrangeR - 1 >= 0 && grid[badOrangeR - 1][badOrangeC] == 1) {
                    grid[badOrangeR - 1][badOrangeC] = 2;
                    freshOrange--;
                    queue.offer(Arrays.asList(badOrangeR - 1, badOrangeC));
                }
                if (badOrangeR + 1 < r && grid[badOrangeR + 1][badOrangeC] == 1) {
                    grid[badOrangeR + 1][badOrangeC] = 2;
                    freshOrange--;
                    queue.offer(Arrays.asList(badOrangeR + 1, badOrangeC));
                }
                if (badOrangeC - 1 >= 0 && grid[badOrangeR][badOrangeC - 1] == 1) {
                    grid[badOrangeR][badOrangeC - 1] = 2;
                    freshOrange--;
                    queue.offer(Arrays.asList(badOrangeR, badOrangeC - 1));
                }
                if (badOrangeC + 1 < c && grid[badOrangeR][badOrangeC + 1] == 1) {
                    grid[badOrangeR][badOrangeC + 1] = 2;
                    freshOrange--;
                    queue.offer(Arrays.asList(badOrangeR, badOrangeC + 1));
                }
            }
        }
        if (freshOrange != 0) return -1;
        return timer;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        OrangesRotting orangesRotting = new OrangesRotting();
        orangesRotting.orangesRotting(grid);

    }
}
