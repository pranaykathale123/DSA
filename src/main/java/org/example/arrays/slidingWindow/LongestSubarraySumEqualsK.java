package org.example.arrays.slidingWindow;

public class LongestSubarraySumEqualsK {
    public static int lenOfLongSubarr(int[] nums, int K) {
        int left = 0, right = 0;
        int sum = 0, maxLen = 0;

        while (right < nums.length) {
            sum += nums[right];

            // Shrink window from the left until sum <= K
            while (sum > K && left <= right) {
                sum -= nums[left];
                left++;
            }

            // Check for equality
            if (sum == K) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 1, 2, 3, 5};
        int K = 5;
        System.out.println(lenOfLongSubarr(nums, K)); // Output: 4  (subarray [1,1,1,2])
    }
}

