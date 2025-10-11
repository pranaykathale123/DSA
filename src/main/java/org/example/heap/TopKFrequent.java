package org.example.heap;

import java.util.*;

public class TopKFrequent {

    /**
     * Problem: Find the Top K frequent elements in an array.
     * <p>
     * Approach:
     * 1. Use a HashMap to store frequency of each element.
     * 2. Use a Min-Heap (PriorityQueue) of size K to store elements
     * based on their frequency — the smallest frequency at the top.
     * 3. If the heap exceeds size K, remove the element with the smallest frequency.
     * 4. At the end, the heap will contain the K most frequent elements.
     * <p>
     * Time Complexity: O(N log K)
     * Space Complexity: O(N)
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each element using HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a Min-Heap (smallest frequency at top)
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Step 3: Add entries to heap, maintaining size <= K
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);

            // If heap size exceeds K, remove least frequent element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Extract keys (top K frequent elements)
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        // Optional: Reverse for descending frequency order
        Collections.reverse(result);

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3};
        int k = 2;

        List<Integer> topK = topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + topK);
    }

}
