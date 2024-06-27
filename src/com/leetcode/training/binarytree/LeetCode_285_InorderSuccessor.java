package com.leetcode.training.binarytree;


import com.leetcode.training.TreeNode;

/**
 * 后继节点
 */
public class LeetCode_285_InorderSuccessor {

    public static void main(String[] args) {
        LeetCode_285_InorderSuccessor client = new LeetCode_285_InorderSuccessor();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);



        System.out.println(client.inorderSuccessor(root, root).val);
    }
    //
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        // 如果当前节点有左子树，则后继节点是左子树的最右节点
        if(p.left != null) {
            p = p.left;
            while(p.right != null) {
                p = p.right;
            }
            return p;
        }

        TreeNode t = null;
        // 没有左子树，则记录前一个小于p的节点
        while(root != null) {
            if(root.val < p.val) {
                t = root;
                root = root.right;
            }else  if(root.val > p.val) {
                root = root.left;
            } else {
                break;
            }
        }

        return t;
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        // 如果当前节点有右子树，找到右子树的最左节点
        if (p.right != null) {
            successor = p;
            p = p.right;
            while (p.left != null) {
                p = p.left;
                successor = p.left;
            }
            return successor;
        }

        while(root != null){
            if(p.val < root.val) {
                successor = root;
                root = root.left;
            } else  if(p.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }

        return successor;

    }


    public TreeNode findPrecursor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        TreeNode t = null;
        while (root != null) {
            if (root.val < p.val) {
                t = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return t;
    }
}
