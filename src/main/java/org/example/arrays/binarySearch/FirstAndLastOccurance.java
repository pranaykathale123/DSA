package org.example.arrays.binarySearch;

public class FirstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int[] result = searchRange(arr, target);
        System.out.println("First Occurrence of " + target + " is at index: " + result[0]);
        System.out.println("Last Occurrence of " + target + " is at index: " + result[1]);
    }


    private static int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];
        result[0] = firstOccurrence(nums,target);
        result[1] = lastOccurrence(nums,target);
        return result;
    }
    private static int firstOccurrence(int nums[], int target){
        int si=0;
        int ei=nums.length-1;
        int ans=-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(nums[mid]==target){
                ans=mid;
                ei=mid-1;
            }
            else if(nums[mid]<target){
                si=mid+1;
            }
            else{
                ei=mid-1;
            }
        }
        return ans;
    }
    private static int lastOccurrence(int nums[], int target){
        int si=0;
        int ei=nums.length-1;
        int ans=-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(nums[mid]==target){
                ans=mid;
                si=mid+1;
            }
            else if(nums[mid]<target){
                si=mid+1;
            }
            else{
                ei=mid-1;
            }
        }
        return ans;
    }

}
