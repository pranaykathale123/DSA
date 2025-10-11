package org.example.heap;

import java.util.*;

public class KClosest {
    /**
     * Problem: Find K closest elements to a given number X in an array.
     * <p>
     * Approach:
     * - Use a Max-Heap (PriorityQueue with reverse order based on absolute difference).
     * - Each heap node will store a pair: (|arr[i] - x|, arr[i]).
     * - If the heap size exceeds K, remove the element with the largest difference.
     * - Finally, the heap will contain K elements closest to X.
     * <p>
     * Time Complexity: O(N log K)
     * Space Complexity: O(K)
     */
    public static ArrayList<Integer> printKClosest(int[] arr, int n, int k, int x) {

        // Max-Heap storing pairs (difference, element)
        // Larger difference = higher priority (so we can remove it first)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]  // Sort by difference descending
        );

        for (int num : arr) {
            int diff = Math.abs(num - x);

            // Add pair to the heap
            maxHeap.offer(new int[]{diff, num});

            // Keep heap size at most K
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract elements from heap (these are K closest)
        ArrayList<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]);
        }

        // Optional: sort result by closeness (or ascending order)
        Collections.sort(result);

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        int k = 3;
        int x = 7;

        ArrayList<Integer> closest = printKClosest(arr, arr.length, k, x);
        System.out.println("K closest elements to " + x + " are: " + closest);
    }
}
