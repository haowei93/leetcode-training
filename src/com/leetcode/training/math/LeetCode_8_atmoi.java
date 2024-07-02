package com.leetcode.training.math;

/**
 * @author haowei.chen
 * @since 2024/6/30 16:53
 */
public class LeetCode_8_atmoi {

    public static void main(String[] args) {
        LeetCode_8_atmoi client = new LeetCode_8_atmoi();
        System.out.println(client.myAtoi("42"));
        System.out.println(client.myAtoi("   -42"));
        System.out.println(client.myAtoi("4193 with words"));
        System.out.println(client.myAtoi("words and 987"));
        System.out.println(client.myAtoi("-91283472332"));
        System.out.println(client.myAtoi("   -0"));

    }
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        // 先去掉空格
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }

        // 记录正负号
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        if (i == n) {
            return 0;
        }

        // 开始统计数字位
        long res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');
            // 检查是否溢出
            if (res > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }

        return (int) res * sign;
    }
}
