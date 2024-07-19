package com.leetcode.training;

/**
 * @author haowei
 */
public class Solution {


    public static void main(String[] args) {
        int[] res = countNum(new int[]{1, 2, 3, 4, 5});
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
        res = countNum2(new int[]{1, 2, 3, 4, 5});
        for (int re : res) {
            System.out.print(re + " ");
        }

    }


    //a[] 是长度为 n 的正整数数组，i、j 为该数组下标满足 0 <= i < j < n，
    //求 i、j 使得 s = a[i] + a[j] 取值最大，返回此时的 [i, j, s]
    // o(n2)
    public static int[] countNum(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int[] result = new int[3];
        for (int i = 0; i < nums.length-1; i++) {
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
        int firstIndex = -1;

        int secondNum = Integer.MIN_VALUE;
        int secondIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstNum) {
                secondNum = firstNum;
                secondIndex = firstIndex;
                firstNum = nums[i];
                firstIndex = i;
            } else if (nums[i] > secondNum && i != firstIndex) {
                secondNum = nums[i];
                secondIndex = i;
            }
        }
        return new int[]{firstIndex, secondIndex, firstNum + secondNum};
    }


}
