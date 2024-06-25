package com.leetcode.training.binarysearch;

public class LeetCode_4_FindMedianSortedArrays {

    public static void main(String[] args) {
        int [] nums1 = {1,3,5,7};
        int [] nums2 = {2,4};

        LeetCode_4_FindMedianSortedArrays client = new LeetCode_4_FindMedianSortedArrays();

        System.out.println( client.findMedianSortedArraysWithArray(nums1, nums2));

    }

    public double findMedianSortedArraysWithArray(int[] nums1, int[] nums2) {

        int x = nums1.length;
        int y = nums2.length;
        // 暴力法，如果是奇数个， （x+y）/2  的位置返回即可，如果是偶数个， （x+y）/2 和 （x+y）/2 -1 位置的平均值返回即可
        boolean isOdd = (x + y) % 2 != 0;
        int mid = (x + y) / 2;
        int[] combins = new int[mid+1];
        int count  = 0;
        int i=0, j=0;
        while(count <= mid && i < x && j < y) {
            if(nums1[i] < nums2[j]) {
                combins[count++] = nums1[i++];
            } else {
                combins[count++] = nums2[j++];
            }
        }
        while(count <= mid && i < x) {
            combins[count++] = nums1[i++];
        }

        while(count <= mid && j < y) {
            combins[count++] = nums2[j++];
        }

        return isOdd? combins[mid] : (combins[mid] + combins[mid-1]) / 2.0;

    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = nums1.length;

        while (low <= high) {
            int partationX = low + (high - low) / 2;

            int partationY = (x + y + 1) / 2 - partationX;

            int maxLeftX = (partationX == 0) ? Integer.MIN_VALUE : nums1[partationX - 1];
            int minRightX = (partationX == x) ? Integer.MAX_VALUE : nums1[partationX];

            int maxLeftY = (partationY == 0) ? Integer.MIN_VALUE : nums2[partationY - 1];
            int minRightY = (partationY == y) ? Integer.MAX_VALUE : nums2[partationY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partationX - 1;
            } else {
                low = partationX + 1;
            }
        }
        throw new RuntimeException("errror arrays!");
    }
}
