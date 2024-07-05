package com.leetcode.training.parentheses;

import java.util.Stack;

/**
 * @author haowei.chen
 * @since 2024/7/5 20:31
 */
public class LeetCode_32_LongestValidParentheses {


    public static void main(String[] args) {
        LeetCode_32_LongestValidParentheses instance = new LeetCode_32_LongestValidParentheses();
        System.out.println(instance.longestValidParentheses("(()"));
        System.out.println(instance.longestValidParentheses(")()())"));
        System.out.println(instance.longestValidParentheses(""));
    }
    public int longestValidParentheses(String s) {

        // 1. 用栈来存储括号的下标
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        // 2. 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 3. 遇到右括号
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                // 4. 栈为空，说明当前的右括号没有匹配的左括号
                if (stack.isEmpty()) {
                    // 更新当前记录下标
                    stack.push(i);
                } else {
                    // 5. 栈不为空，说明当前的右括号有匹配的左括号
                    ans = Math.max(ans, i - stack.peek());
                }
            }

        }

        return ans;
    }


}