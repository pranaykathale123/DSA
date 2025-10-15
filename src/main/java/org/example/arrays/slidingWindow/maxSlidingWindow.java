package org.example.arrays.slidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(arr, k);
        System.out.println("Maximums in each sliding window of size " + k + ":");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];

        Deque<Integer> dq = new LinkedList<>(); // will store indices
        int[] result = new int[n - k + 1];
        int ri = 0;

        for (int i = 0; i < n; i++) {
            // 1️⃣ Remove indices that are out of this window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2️⃣ Remove all elements smaller than the current element nums[i]
            // because they will never be needed (as nums[i] is bigger and later)
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3️⃣ Add current element’s index
            dq.offerLast(i);

            // 4️⃣ If our window has hit size k, record the max (front of deque)
            if (i >= k - 1) {
                result[ri++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }

}
