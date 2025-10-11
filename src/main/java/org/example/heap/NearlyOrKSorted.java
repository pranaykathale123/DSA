package org.example.heap;

import java.util.*;

public class NearlyOrKSorted {

    /**
     * This class provides a solution to sort a nearly sorted (or K-sorted) array.
     * <p>
     * A K-sorted array is one where every element is at most K positions away
     * from its correct position in the sorted order.
     * <p>
     * Example:
     * Input: arr = [6, 5, 3, 2, 8, 10, 9], K = 3
     * Output: [2, 3, 5, 6, 8, 9, 10]
     * <p>
     * Approach:
     * - We use a Min-Heap (PriorityQueue) of size K+1 to efficiently get the smallest element
     * among the next K+1 elements.
     * - At any point, the smallest element among the current window of K+1 elements
     * must be the next element in the sorted order.
     * <p>
     * Time Complexity: O(N log K)
     * Space Complexity: O(K)
     */
    ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        // Min-Heap to store the next K+1 elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // List to store the final sorted elements
        ArrayList<Integer> sortedList = new ArrayList<>();

        // Step 1: Traverse the array and push elements into the heap
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]); // Add element to heap

            // Step 2: If heap size exceeds k, remove and add the smallest element to the result
            if (pq.size() > k) {
                sortedList.add(pq.poll());
            }
        }

        // Step 3: Add the remaining elements from heap to result
        while (!pq.isEmpty()) {
            sortedList.add(pq.poll());
        }

        return sortedList;
    }
}
