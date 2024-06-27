package com.leetcode.training.binarytree;

import com.leetcode.training.TreeNode;

/**
 * @author haowei.chen
 * @since 2024/6/27 10:22
 */
public class InOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("inOrder: " + inOrder(root));
    }
    private static String inOrder(TreeNode node){
        if (node == null) return "";
        return inOrder(node.left) + node.val + inOrder(node.right);
    }

}
