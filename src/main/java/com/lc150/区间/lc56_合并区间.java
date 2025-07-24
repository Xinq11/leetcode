package com.lc150.区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lc56_合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> res = new ArrayList<int[]>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] son = intervals[i];
            int sonl = son[0];
            int sonr = son[1];
            if (sonl >= l && sonl <= r) {
                r = Math.max(r, sonr);
            } else if (sonl > r || (sonl < l && sonr < l)) {
                res.add(new int[]{l, r});
                l = sonl;
                r = sonr;
            } else {
                l = sonl;
                r = Math.max(r, sonr);
            }
        }
        res.add(new int[]{l, r});
        int[][] array = new int[res.size()][];
        return res.toArray(new int[res.size()][]);
    }
}
