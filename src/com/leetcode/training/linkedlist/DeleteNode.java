package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * @author haowei.chen
 * @since 2024/7/14 17:31
 */
public class DeleteNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        ListNode node5 = new ListNode(6);
        node4.next = node5;
        ListNode node6 = new ListNode(7);
        node5.next = node6;
        ListNode node7 = new ListNode(8);
        node6.next = node7;
        ListNode node8 = new ListNode(9);
        node7.next = node8;
        ListNode node9 = new ListNode(10);
        node8.next = node9;

        ListNode result = deleteNodeWithO1(head, head.next);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    /**
     * 实现单向链表的删除方法，
     * 入参为deleteNode Node，
     * 要求实现时间复杂度为0(n)和0(1)的两种算法，
     * 空间复杂度也要求为0(1)，代码需要最终可运行
     */
    public static ListNode deleteNode(ListNode head, ListNode deleteNode) {

        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        dummyHead.next = head;
        ListNode cur = head;

        while (cur != null) {
            if (cur == deleteNode) {
                pre.next = cur.next;
                cur.next = null;
                return dummyHead.next;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return dummyHead.next;
    }

    // O(1) 复杂度删除链表
    public static ListNode deleteNodeWithO1(ListNode head, ListNode deleteNode) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;

        if(deleteNode.next != null) {
            deleteNode.val = deleteNode.next.val;
            deleteNode.next = deleteNode.next.next;
            return  head;
        } else {
            if(deleteNode == head) {
                return null;
            } else {
                // 找到尾节点
                while (cur != deleteNode) {
                    cur = cur.next;
                    pre = pre.next;
                }
                pre.next = null;
                return head;
            }
        }

    }

}
