package com.leetcode.training.binarytree;

import com.leetcode.training.TreeNode;

/**
 * @author haowei.chen
 * @since 2024/6/27 10:23
 */
public class PreOrder {

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            System.out.println("preOrder: " + preOrder(root));
        }
        private static String preOrder(TreeNode node){
            if (node == null) return "";
            return node.val + preOrder(node.left) + preOrder(node.right);
        }

}
