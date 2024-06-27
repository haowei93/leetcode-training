package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * @author haowei.chen
 * @since 2024/6/27 17:33
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 1,2,3,4,5
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseListWithRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1,2,3,4,5
        ListNode newHead = reverseListWithRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }



    }
