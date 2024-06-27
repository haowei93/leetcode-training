package com.leetcode.training.binarysearch;

import java.util.Objects;

public class FindTarget {


    /**
     * 疑问1： m是否始终处于[0，N)以内？
     * 最小值mid =0, 此时l = -1, r = 0;
     * 最大值mid = n-1, 此时l = n-2, l = n;
     *
     * 疑问2： 会不会出现死循环
     * 举例子 l+3 = r
     * 下一步： l = mid  ==> l+2 = r， 继续循环  l=mid  =>>> l+1 = r
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 4, 4, 4, 6};
        FindTarget findTarget = new FindTarget();
//        System.out.println(findTarget.findTarget(nums, 5, 8));
//        System.out.println(findTarget.findTarget(nums, 11, 7.10));
//        System.out.println(findTarget.findTarget(nums, 11, 999));

        System.out.println(findTarget.findLastTarget(nums, 4));


    }

    public int findTarget(int[] nums, int n, double target) {
        if (n <= 0) {
            return -1;
        }
        if (n > nums.length) {
            n = nums.length + 1;
        }
        int length = n - 1;
        int low = -1, high = length;
        while (low + 1 != high) {
            int mid = low + (high - low) / 2;
            if (Objects.equals(nums[mid], target)) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public int findFirstTarget(int[] a, int target) {
        int left = -1, right = a.length;
        while (left + 1 != right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] >= target) {
                right = mid;
            } else if (a[mid] < target) {
                left = mid;
            }
        }
        return right;
    }

    public int findLastTarget(int[] a, int target) {
        int left = -1, right = a.length;
        while (left + 1 != right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] > target) {
                right = mid;
            } else if (a[mid] <= target) {
                left = mid;
            }
        }
        return left;
    }
}
