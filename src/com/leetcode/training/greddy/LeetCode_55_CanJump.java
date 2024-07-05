package com.leetcode.training.greddy;

/**
 * @author haowei.chen
 * @since 2024/7/5 22:40
 */
public class LeetCode_55_CanJump {

    public static void main(String[] args) {
        LeetCode_55_CanJump instance = new LeetCode_55_CanJump();
        System.out.println(instance.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(instance.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxReach < i) {
                return false;
            }
            maxReach = Math.max(maxReach, nums[i] + i);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
