package com.leetcode.training.topk;

import java.util.Arrays;

/**
 * @author haowei.chen
 * @since 2024/7/3 18:07
 */
public class MaxHeap {

        private int[] results;
        private int size;

        public MaxHeap(int capacity) {
            results = new int[capacity];
            size = 0;
        }

        private int left(int i) {
            return 2 * i + 1;
        }

        private int right(int i) {
            return 2 * i + 2;
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        public int peek() {
            if (size == 0) throw new IllegalStateException("Heap is empty");
            return results[0];
        }

        public int pop() {
            if (size == 0) throw new IllegalStateException("Heap is empty");
            int result = results[0];
            results[0] = results[size - 1];
            size--;
            siftDown(0);
            return result;
        }

        public int size() {
            return size;
        }

        public void offer(int num) {
            if (size == results.length) {
                results = Arrays.copyOf(results, size * 2); // 动态扩容
            }
            results[size] = num;
            size++;
            siftUp(size - 1);
        }

        private void siftUp(int i) {
            while (i > 0 && results[parent(i)] < results[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        private void siftDown(int i) {
            while (true) {
                int maxPos = i;
                if (left(i) < size && results[left(i)] > results[maxPos]) {
                    maxPos = left(i);
                }
                if (right(i) < size && results[right(i)] > results[maxPos]) {
                    maxPos = right(i);
                }
                if (maxPos == i) {
                    break;
                }
                swap(i, maxPos);
                i = maxPos;
            }
        }

        private void swap(int i, int j) {
            int tmp = results[i];
            results[i] = results[j];
            results[j] = tmp;
        }

        public static void main(String[] args) {
            MaxHeap heap = new MaxHeap(6);
            heap.offer(3);
            heap.offer(1);
            heap.offer(6);
            heap.offer(5);
            heap.offer(2);
            heap.offer(4);

            System.out.println("Heap size: " + heap.size());
            System.out.println("Top element: " + heap.peek());

            while (heap.size() > 0) {
                System.out.println(heap.pop());
            }
        }
    }
