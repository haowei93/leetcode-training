package com.leetcode.training.topk;



import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKthRecord {
    public static void main(String[] args) {
        String[] s = {"a", "b", "c", "d", "a", "d", "e",
                "a", "b", "c", "d2", "aa", "d", "e1",
                "a", "bc", "c", "d", "aa", "d", "e"};
        int[] nums = {1, 2, 3, 4, 5, 5, 6, 6, 6, 5465, 4, 45, 5654, 65, 4, 4};
        System.out.println(findKthLargest(nums, 5));
        topK(s);
    }

    public static PriorityQueue<Integer> findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k, (a,b)-> b-a);
        for (int num : nums) {
            if (minQueue.size() < k || num > minQueue.peek()) ;
            if (minQueue.size() > k)
                minQueue.poll();
        }
        return minQueue;
    }

    public static void topK(String[] str) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : str) {
            if (map.containsKey(s)) {
                int count = map.get(s);
                map.put(s, count + 1);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map);
    }
}
