package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * @author chenhaowei
 * @date 2019.04.21
 */
public class LeetCode_83_RemoveDup {
    public static void main(String[] args) {
        // 创建一个示例链表 1->1->2->3->3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        LeetCode_83_RemoveDup solution = new LeetCode_83_RemoveDup();
        ListNode newHead = solution.deleteDuplicates(head);

        // 打印移除重复元素后的链表
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        // 输出: 2
    }

    public  ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // 跳过所有重复的节点
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            // 如果 prev 的下一个节点就是 current，说明 current 没有重复
            if (prev.next == current) {
                prev = prev.next;
            } else {
                // 否则，跳过所有重复的节点
                prev.next = current.next;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static ListNode getList(ListNode head) {
        ListNode n1 = new ListNode(1);
        head.next = n1;
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        ListNode n3 = new ListNode(2);
        n2.next = n3;
        ListNode n4 = new ListNode(3);
        n3.next = n4;
        ListNode n5 = new ListNode(3);
        n4.next = n5;

        return head;
    }

    public ListNode deleteDuplicate(ListNode head) {

        ListNode ref = head;
        while (ref.next != null) {
            if (ref.val == ref.next.val) {
                ref.next = ref.next.next;
            } else {
                ref = ref.next;
            }
        }
        return head;


    }
}
