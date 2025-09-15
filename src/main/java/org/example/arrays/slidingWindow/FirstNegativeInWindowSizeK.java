package org.example.arrays.slidingWindow;
import java.util.ArrayList;

public class FirstNegativeInWindowSizeK {
    public static void main(String[] args) {
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        long [] result = printFirstNegativeInteger(arr,arr.length, k);
        System.out.println("First negative integers in each window of size " + k + ":");
        for (long num : result) {
            System.out.print(num + " ");
        }
    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        int i=0;
        int j=0;
        ArrayList<Long> list = new ArrayList<>(); //{12, -1, -7, 8, -15, 30, 16, 28};
        long [] arr = new long[A.length-K+1];     //{-1,}
        while(j<N){
            if(A[j]<0){
                list.add(A[j]);
            }
            if(j-i+1==K){
                int front = list.size()-list.size();
                if(list.isEmpty()){
                    arr[i] = 0;
                }
                else {
                    arr[i]=list.get(front);
                    if(list.get(front)==A[i]){
                        list.remove(front);
                    }
                }
                i++;
            }
            j++;
        }
        return arr;
    }
}
