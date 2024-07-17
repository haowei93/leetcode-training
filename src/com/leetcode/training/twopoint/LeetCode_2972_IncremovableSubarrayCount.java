package com.leetcode.training.twopoint;

/**
 * @author haowei.chen
 * @since 2024/7/14 17:33
 */
public class LeetCode_2972_IncremovableSubarrayCount {


    public static void main(String[] args) {
        int[] a = {6, 5, 7, 8};
        System.out.println(incremovableSubarrayCount(a));
    }

    public static long incremovableSubarrayCount(int[] a) {
        int n = a.length;
        int i = 0;

        // 找到最长的递增前缀
        while (i < n - 1 && a[i] < a[i + 1]) {
            i++;
        }
        // 如果整个数组都是严格递增的
        if (i == n - 1) {
            return (long) n * (n + 1) / 2;
        }



        long ans = i + 2; // 不保留后缀的情况，一共 i+2 个

        // 枚举保留的后缀为 a[j:]
        for (int j = n - 1; j == n - 1 || a[j] < a[j + 1]; j--) {
            while (i >= 0 && a[i] >= a[j]) {
                i--;
            }
            /**
             * 对于每个 j，我们可以保留的前缀数量是 i + 2。这是因为：
             * 可以保留的前缀包括从 a[0] 到 a[i] 的所有前缀（i + 1 个）。
             * 以及整个数组 a 本身（1 个）。
             * 总共是 i + 2 个
             */
            ans += i + 2;
        }
        // 6,5,7,8

        /**
         * 例如 a=[6,5,7,8]，计算出的 i=0，可以移除：
         *
         * 下标范围 [1,3]，即后缀 [5,7,8]，剩余元素为 [6]。
         * 下标范围 [0,3]，即后缀 [6,5,7,8]，剩余元素为 []。
         * 下标范围 [1,2]，即后缀 [5,7]，剩余元素为 [6,8]。
         * 下标范围 [0,2]，即后缀[6,5,7]，剩余元素为 [8]
         * 下标范围 [1,1]，即后缀[5]，剩余元素为 [6,7,8]
         *
         */

        return ans;
    }
}
