package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * @author chenhaowei
 * @date 2019.05.19
 */
public class LeetCode_203_Remove_Linked_List_Elements {


    public static void main(String[] args) {
        // 创建一个示例链表 1->1->2->3->3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        LeetCode_203_Remove_Linked_List_Elements solution = new LeetCode_203_Remove_Linked_List_Elements();
        ListNode newHead = solution.removeElements(head,3);

        // 打印移除重复元素后的链表
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        // 输出: 1 2 3
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }
}
