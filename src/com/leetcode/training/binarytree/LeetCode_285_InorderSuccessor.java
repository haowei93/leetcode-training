package com.leetcode.training.binarytree;


import com.leetcode.training.TreeNode;

/**
 * 后继节点
 */
public class LeetCode_285_InorderSuccessor {

    public static void main(String[] args) {
        // 创建一个示例二叉搜索树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        LeetCode_285_InorderSuccessor solution = new LeetCode_285_InorderSuccessor();
        TreeNode p = root.left.right; // 节点 4
        TreeNode successor = solution.successor(root, p);
        if (successor != null) {
            System.out.println("后继节点的值是: " + successor.val); // 应该输出 5
        } else {
            System.out.println("没有后继节点");
        }
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
