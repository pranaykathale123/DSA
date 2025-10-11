package org.example.heap;

import java.util.*;

public class TopKFrequentBucketSort {

    /**
     * Problem: Find the Top K frequent elements in an array.
     * Approach: Using Bucket Sort (O(N))
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency
        // Each bucket[i] holds list of elements with frequency i
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }

        // Step 3: Collect elements from buckets starting from highest frequency
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        // If more than k (rare case when multiple have same freq), trim list
        return result.subList(0, k);
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3};
        int k = 2;

        List<Integer> topK = topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + topK);
    }
}

