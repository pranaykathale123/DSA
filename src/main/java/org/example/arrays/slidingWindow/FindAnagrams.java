package org.example.arrays.slidingWindow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static void main(String args[]) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));

    }
    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        int j = 0;
        int i = 0;
        while(j < s.length()){
            sCount[s.charAt(j) - 'a']++;
            if((j-i+1) == p.length()){
                if(Arrays.equals(pCount, sCount)){
                    result.add(i);
                }
                sCount[s.charAt(i) - 'a']--;
                i++;

            }
            j++;
        }
        return result;
    }
}