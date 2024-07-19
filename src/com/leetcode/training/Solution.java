package com.leetcode.training;

/**
 * @author haowei
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(countNum2(new int[]{1, 2, 3, 4, 5}));
        System.out.println(countNum2(new int[]{1, 2, 3, 4, 5}));

    }


    //a[] 是长度为 n 的正整数数组，i、j 为该数组下标满足 0 <= i < j < n，
    //求 i、j 使得 s = a[i] + a[j] 取值最大，返回此时的 [i, j, s]
    // o(n2)
    public static int[] countNum(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int[] result = new int[3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (maxValue < nums[i] + nums[j]) {
                    // 临时存储当前结果
                    maxValue = nums[i] + nums[j];
                    result = new int[]{i, j, maxValue};
                }
            }
        }
        return result;
    }

    public static int[] countNum2(int[] nums) {

        int firstNum = Integer.MIN_VALUE;
        int firstIndex = 0;

        int secondNum = Integer.MIN_VALUE;
        int secondIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (firstNum < nums[i]) {
                firstNum = nums[i];
                firstIndex = i;
            }
            if (secondNum <= firstNum && firstIndex != secondIndex) {
                secondNum = nums[i];
                secondIndex = i;
            }
        }
        return new int[]{firstIndex, secondIndex, firstNum + secondNum};
    }


}
