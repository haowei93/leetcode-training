package com.leetcode.training.topk;

public class Heap {
    private int[] results;

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2; // 向下整除
    }

    private int peek()  {
        return results[0];
    }

    public int size() {
        return results.length;
    }
    public void offer(int num) {
        results[0] = num;
//        siftUp(size()-1);
    }




}
