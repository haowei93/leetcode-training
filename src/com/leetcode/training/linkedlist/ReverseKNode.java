package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * @author haowei.chen
 * @since 2024/6/27 17:44
 */
public class ReverseKNode {

    public static void main(String[] args) {
        // 创建一个示例链表 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseKNode solution = new ReverseKNode();
        ListNode newHead = solution.reverseKGroup(head, 3);

        // 打印反转前 3 个节点后的链表
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        System.out.println();
        // 输出: 3 2 1 4 5
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    ListNode successor = null;

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (k == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseKGroup2(head.next, k - 1);
        head.next.next = head;
        head.next = successor;

        return last;


    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
