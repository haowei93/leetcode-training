package com.leetcode.training;

/**
 * @author haowei
 */
public class Solution {

    /**
     * 正则表达式规则：
     * [] 匹配括号内的支付
     * [abc] 匹配a或b或c
     * [a-z] 匹配a到z的任意字符
     * [0-9] 匹配0到9的任意字符
     *
     * {} 匹配前面字符出现的次数
     * {n} 匹配前面字符出现n次
     * {n,} 匹配前面字符至少 n 次
     * {n,m} 匹配前面字符出现n次到m次
     *  {,n} 匹配前面字符出现至多 n 次
     *
     *  ｜ 匹配左右任意一个表达式
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isValidIpV4WithRegex("asds.11223.sd23"));
    }

    private static boolean isValidIpV4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            if (part.isEmpty()) {
                return false;
            }

            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidIpV4WithRegex(String ip) {
        return ip.matches(
                "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$");
    }

}
