package com.leetcode.training.math;

/**
 * @author haowei.chen
 * @since 2024/6/30 16:58
 */
public class LeetCode_7_Reverse_Integer {


    public static void main(String[] args) {
        LeetCode_7_Reverse_Integer client = new LeetCode_7_Reverse_Integer();
        System.out.println(client.reverse(123));
        System.out.println(client.reverse(-123));
        System.out.println(client.reverse(120));
        System.out.println(client.reverse(0));
        System.out.println(client.reverse(1134236469));
    }
    public int reverse(int x) {
        if(x == 0) return x;
        long res = 0;
        while(x != 0) {
            res = res*10 + x%10;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            x = x/10;
        }
        return (int) res;

    }

}
