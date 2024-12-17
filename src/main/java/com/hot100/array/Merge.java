package com.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2024.12.08 合并区间
 * https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&envId=top-100-liked
 * md 好多脑筋急转弯的题 感觉
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> res = new ArrayList<int[]>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            int[] son = intervals[i];
            int sonl = son[0];
            int sonr = son[1];
            if (sonl >= l && sonl <= r) {
                r = Math.max(r, sonr);
            } else if (sonl > r || (sonl < l && sonr < l)){
                res.add(new int[]{l, r});
                l = sonl;
                r = sonr;
            } else {
                l = sonl;
                r = Math.max(r,sonr);
            }
        }
        res.add(new int[]{l, r});
        return res.toArray(new int[res.size()][]);
    }
}
