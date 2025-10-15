package org.example.heap;
import java.util.*;

public class MinCostToConnectNropes {
public static void main(String[] args) {
    int[] ropes = {1, 2, 3, 4, 5};
    System.out.println("Minimum cost to connect ropes: " + minCostToConnectRopes(ropes));
}

    /**
     * Problem: Given N ropes of different lengths, connect them into one rope with minimum cost.
     * The cost to connect two ropes is equal to the sum of their lengths.
     * <p>
     * Approach:
     * 1. Use a Min-Heap (PriorityQueue) to store the lengths of the ropes.
     * 2. Repeatedly extract the two shortest ropes, connect them, and add the cost to the total.
     * 3. Insert the new rope back into the heap.
     * 4. Continue until only one rope remains.
     * <p>
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public static int minCostToConnectRopes(int[] ropes) {
        // Min-Heap to store rope lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) {
            minHeap.offer(rope);
        }

        int totalCost = 0;

        // While more than one rope remains
        while (minHeap.size() > 1) {
            // Step 1: Extract the two shortest ropes
            int first = minHeap.poll();
            int second = minHeap.poll();

            // Step 2: Connect them and calculate cost
            int cost = first + second;
            totalCost += cost;

            // Step 3: Insert the new rope back into the heap
            minHeap.offer(cost);
        }

        return totalCost;
    }
}
