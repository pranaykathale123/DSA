package org.example.arrays.slidingWindow;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = maxSumSubArray(arr, k);
        int bruteResult = maxSumSubArrayBruteForce(arr, k);
        System.out.println("Brute Force Result: " + bruteResult);
        System.out.println("Maximum sum of a subarray of size " + k + " is: " + result);
    }

    private static int maxSumSubArrayBruteForce(int[] arr, int k) {
        int maxSum = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += arr[j];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    private static int maxSumSubArray(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // Add the next element to the window

            // Slide the window when we hit the size 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum); // Update maxSum if needed
                windowSum -= arr[windowStart]; // Remove the element going out of the window
                windowStart++; // Slide the window ahead
            }
        }
        return maxSum;

       /* int i=0;
        int j=0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int n = arr.length;
        while(j < n){
            sum += arr[j];
            if((j-i+1) < k ){
                j++;
            }
            else if((j-i+1) == k){
                maxSum = Math.max(sum,maxSum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }*/
    }
}
