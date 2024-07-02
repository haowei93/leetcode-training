package com.leetcode.training.array;

/**
 * @author haowei.chen
 * @since 2024/7/1 09:50
 */
public class LeetCode_26_RemoveDuplicatesSortedArray {


    public static void main(String[] args) {
        LeetCode_26_RemoveDuplicatesSortedArray client = new LeetCode_26_RemoveDuplicatesSortedArray();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(client.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;

    }
}
