package com.leetcode.training.twopoint;

/**
 * @author haowei.chen
 * @since 2024/7/17 11:12
 */
public class LeetCode_415_AddStrings {

    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "111";
        LeetCode_415_AddStrings solution = new LeetCode_415_AddStrings();
        System.out.println(solution.addStrings(num1, num2));
    }
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);

        }

        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
