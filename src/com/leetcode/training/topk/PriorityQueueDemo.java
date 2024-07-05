package com.leetcode.training.topk;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        int[] array = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};
        // 默认小根堆，升序排列， 限定大小可以得到最大的 k 个值
        PriorityQueue queue = new PriorityQueue(5);
        for(int num: array) {
            if(queue.size() < 5) {
                queue.offer(num);
            } else {
                if((int)queue.peek() < num) {
                    System.out.print("出对" + queue.peek() +" ");
                    System.out.println();
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // 大根堆， 降序排列， 限定大小可以得到最小的 k 个值
        queue = new PriorityQueue(5, Comparator.reverseOrder());
        for(int num: array) {
            if(queue.size() < 5) {
                queue.offer(num);
            } else {
                if((int)queue.peek() > num) {
                    System.out.print("出对" + queue.peek() +" ");
                    System.out.println();
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
