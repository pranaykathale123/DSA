package org.example.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KclosestToOrigin {

    /**
     * Problem: Find the K closest points to the origin (0,0) in a 2D plane.
     * <p>
     * Approach:
     * 1. Use a Max-Heap (PriorityQueue) of size K to store points based on their distance from the origin.
     * 2. Calculate the squared distance for each point to avoid computing square roots.
     * 3. If the heap exceeds size K, remove the point with the largest distance.
     * 4. At the end, the heap will contain the K closest points.
     * <p>
     * Time Complexity: O(N log K)
     * Space Complexity: O(K)
     */
    public static int[][] kClosest(int[][] points, int k) {
        // Max-Heap to store points based on their distance from origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(distance(b), distance(a))
        );

        // Step 1: Add points to the heap
        for (int[] point : points) {
            maxHeap.offer(point);

            // Step 2: If heap size exceeds K, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Step 3: Extract K closest points from the heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    // Helper method to calculate squared distance from origin
    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static int[][] kClosestBucketSort(int[][] points, int k) {
        int n = points.length;

        // Step 1: Compute squared distances & find max distance
        int maxDist = 0;
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            int dist = x * x + y * y;
            distances[i] = dist;
            maxDist = Math.max(maxDist, dist);
        }

        // Step 2: Create buckets (distance → list of points)
        // Using an array of lists as buckets
        List<int[]>[] buckets = new ArrayList[maxDist + 1];
        for (int i = 0; i < n; i++) {
            int dist = distances[i];
            if (buckets[dist] == null) {
                buckets[dist] = new ArrayList<>();
            }
            buckets[dist].add(points[i]);
        }

        // Step 3: Collect k closest points starting from smallest distance
        int[][] result = new int[k][2];
        int index = 0;

        for (int i = 0; i <= maxDist && index < k; i++) {
            if (buckets[i] != null) {
                for (int[] p : buckets[i]) {
                    result[index++] = p;
                    if (index == k) break;
                }
            }
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        int[][] closestPointsbucket = kClosestBucketSort(points, k);
        int[][] closestPoints = kClosest(points, k);
        System.out.println("The " + k + " closest points to the origin are:");

        System.out.println("Soluton using MaxHeap:");
        for (int[] point : closestPoints) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
        System.out.println("Soluton using Bucket Sort:");
        for (int[] point : closestPointsbucket) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}
