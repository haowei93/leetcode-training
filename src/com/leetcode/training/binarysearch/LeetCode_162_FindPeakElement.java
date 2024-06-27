package com.leetcode.training.binarysearch;

/**
 * @author haowei.chen
 * @since 2024/6/25 23:46
 */
public class LeetCode_162_FindPeakElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        LeetCode_162_FindPeakElement client = new LeetCode_162_FindPeakElement();
        System.out.println(client.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = -1, right = nums.length;
        while (left + 1 != right) {
            int mid = left + ((right - left) >> 1);
            int lvalue = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int rvalue = mid + 1 >= nums.length ? Integer.MIN_VALUE : nums[mid + 1];
            // 如果一个元素小于右边大于左边， 放蓝色区域， 最后一个放入蓝色区域的就是峰值
            if (lvalue <= nums[mid] && nums[mid] <= rvalue) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
