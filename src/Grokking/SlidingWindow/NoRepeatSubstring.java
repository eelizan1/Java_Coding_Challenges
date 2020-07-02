package Grokking.SlidingWindow;

import java.util.Hashtable;

public class NoRepeatSubstring {
    //Problem Statement #
    //Given a string, find the length of the longest substring which has no repeating characters.
    //
    //Example 1:
    //
    //Input: String="aabccbb"
    //Output: 3
    //Explanation: The longest substring without any repeating characters is "abc".
    //Example 2:
    //
    //Input: String="abbbb"
    //Output: 2
    //Explanation: The longest substring without any repeating characters is "ab".
    //Example 3:
    //
    //Input: String="abccde"
    //Output: 3
    //Explanation: Longest substrings without any repeating characters are "abc" & "cde".
    public static void main(String[] args) {
        System.out.println(findLength("abccdef"));
    }

    static int findLength(String str) {
        // start of the window
        int windowStart = 0;
        // max trackers
        int longestSubString = 0;
        // map to track last index of each ocurrence
        Hashtable<Character, Integer> hashtable = new Hashtable<>();

        for (int i = 0; i < str.length(); i++) {
            // get character
            char rightChar = str.charAt(i);

            // if map has character, shrink window to ensure that we always have distinct characters in the sliding window
            if (hashtable.containsKey(rightChar)) {
                // the index of the last repeated character
                int n =hashtable.get(rightChar) + 1;
                // update window start with wither current value or index of last repeated character
                windowStart = Math.max(windowStart, n);
            } else {
                // if not in map then add character then update longestSubstring length
                hashtable.put(rightChar, i);
                // keep track of current longest length - compare current length with potential new length
                // i - windowStart + 1 = window interval
                int interval = i - windowStart + 1;
                longestSubString = Math.max(longestSubString, interval);
            }
        }
        return longestSubString;
    }


}
