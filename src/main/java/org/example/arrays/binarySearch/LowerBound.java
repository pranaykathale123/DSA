package org.example.arrays.binarySearch;

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 12;
        int result = lowerBound(arr, target);
        System.out.println("Lower Bound of " + target + " is at index: " + result);
    }

    private static int lowerBound(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;
        int ans = nums.length; // Default to length if target is greater than all elements
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (nums[mid] >= target) {
                ans = mid; // Potential answer found
                ei = mid - 1; // Look for a smaller index
            } else {
                si = mid + 1; // Move right
            }
        }
        return ans;
    }
}
