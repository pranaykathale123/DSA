package org.example.arrays.slidingWindow;

public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(arr, k);
        System.out.println("Maximums in each sliding window of size " + k + ":");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {
            // If the previous maximum is out of the current window, find the new maximum
            if (maxIndex < i) {
                maxValue = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    if (nums[j] > maxValue) {
                        maxValue = nums[j];
                        maxIndex = j;
                    }
                }
            } else if (nums[i + k - 1] > maxValue) { // Check the new element entering the window
                maxValue = nums[i + k - 1];
                maxIndex = i + k - 1;
            }
            result[i] = maxValue;
        }
        return result;
    }

}
