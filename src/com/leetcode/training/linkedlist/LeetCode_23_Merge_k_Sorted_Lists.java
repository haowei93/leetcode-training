package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author chenhaowei
 * @date 2019.05.26
 */
public class LeetCode_23_Merge_k_Sorted_Lists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, Comparator.comparingInt(o -> o.val));

        for(ListNode node : lists) {
            if(node != null) {
                queue.add(node);
            }
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);


        ListNode[] lists = new ListNode[]{node1, node2, node3};

        mergeKLists(lists);
    }

}
