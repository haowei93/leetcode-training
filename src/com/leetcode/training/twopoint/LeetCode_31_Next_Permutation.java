package com.leetcode.training.twopoint;

/**
 * @author haowei.chen
 * @since 2024/6/25 11:00
 */
public class LeetCode_31_Next_Permutation {

    public static void main(String[] args) {
        int[] nums = {2, 6, 3, 5, 4, 1};
        new LeetCode_31_Next_Permutation().nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void nextPermutation(int[] nums) {

        /**
         从后向前找到第一个 nums[i] < nums[i + 1] 的位置 i。
         再从后向前找到第一个 nums[j] > nums[i] 的位置 j。
         交换 nums[i] 和 nums[j]。
         最后将 nums[i + 1] 之后的部分反转。

         2, 6, 3, 5, 4, 1
         后两位 4, 1 能否组成更大的排列，答案是不可以，
         同理 5, 4, 1也不可以
         直到3, 5, 4, 1这个排列，因为 3 < 5, 再找到大于3的第一个数4，交换得到 4，5，3，1， 前面的遍历已经确定了后半部分是降序的， 反转就变为升序
         再反转 得到 4，1，3，5

         */

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);  //first=1 , n = 2

    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    private void reverse(int[] nums, int first) {
        for (int i = first, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }
}
