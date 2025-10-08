package org.example.heap;

import java.util.*;

public class KthElementPQ {

    // Function to find kth smallest using Max Heap
    public static int kthSmallest(int[] arr, int k) {
        // Max Heap (store smallest k elements, root is the largest among them)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove largest, keep only k smallest
            }
        }
        return maxHeap.peek(); // root is kth smallest
    }

    // Function to find kth largest using Min Heap
    public static int kthLargest(int[] arr, int k) {
        // Min Heap (store largest k elements, root is the smallest among them)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest, keep only k largest
            }
        }
        return minHeap.peek(); // root is kth largest
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println(k + "rd Smallest: " + kthSmallest(arr, k));
        System.out.println(k + "rd Largest: " + kthLargest(arr, k));
    }
}
