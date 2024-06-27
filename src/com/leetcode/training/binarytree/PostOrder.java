package com.leetcode.training.binarytree;

import com.leetcode.training.TreeNode;

/**
 * @author haowei.chen
 * @since 2024/6/27 10:24
 */
public class PostOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("postOrder: " + postOrder(root));
    }
    private static String postOrder(TreeNode node){
        if (node == null) return "";
        return postOrder(node.left) + postOrder(node.right) + node.val;
    }

}
