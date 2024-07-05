package com.leetcode.training.interval;

import java.util.Arrays;

/**
 * example: [1,2],[1,4],[3,4]
 */
public class LeetCode_1288_Remove_Covered_Intervals {

    public static void main(String[] args) {
        LeetCode_1288_Remove_Covered_Intervals client = new LeetCode_1288_Remove_Covered_Intervals();
        int[][] intervals = new int[][]{{1, 4}, {3, 6}, {2, 8}};
        System.out.println(client.removeCoveredIntervals(intervals));
    }

    public int removeCoveredIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                // 相同起点，大的在前多消一次
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        // 区间覆盖， 区间相交-扩大， 区间无交集-更新下标， 统计相交的个数
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            // 情况一，找到覆盖区间，直接++res
            if (left <= cur[0] && right >= cur[1]) {
                res++;
            } else if (cur[0] < right) {
                // 情况二，找到相交区间，合并
                right = cur[1];  // [1,8]
            } else {
                // 情况三，完全不相交，更新起点和终点
                left = cur[0];
                right = cur[1];
            }

        }
        return intervals.length - res;

    }

}
