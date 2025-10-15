package org.example.heap;

import java.util.Collections;
import java.util.*;

public class SumBetweenK1K2 {
    /**
     * Problem: Given an array, find the sum of all elements between the k1-th and k2-th smallest elements.
     * Approach: Using Max Heap to keep track of the k2-1 smallest elements and then summing the elements
     * between k1-th and k2-th smallest.
     */
    public static int sumBetweenK1K2(int[] nums, int k1, int k2) {
        int k1Smallest = getKthSmallest(nums, k1);
        int k2Smallest = getKthSmallest(nums, k2);
        int result = 0;
        for (int num : nums) {
            if (num > k1Smallest && num < k2Smallest) {
                result += num;
            }
        }
        return result;
    }

    private static int getKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {20, 8, 22, 4, 12, 10, 14};
        int k1 = 3;
        int k2 = 6;

        int result = sumBetweenK1K2(nums, k1, k2);
        System.out.println("Sum of elements between " + k1 + "-th and " + k2 + "-th smallest: " + result);
    }

}
