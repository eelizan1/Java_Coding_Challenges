package Grokking.SlidingWindow;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LongestSubString {
    //Given a string, find the length of the longest substring in it with no more than K distinct characters.
    public static void main(String[] args) {
       // System.out.println(findLength("araaci", 2));
        System.out.println(mapString("araaci"));
    }

    static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();

        int windowStart = 0, maxLength = 0;
        //Map<Character, Integer> charFrequencyMap = new HashMap<>();
        Hashtable<Character, Integer> charFrequencyMap = new Hashtable<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }

    static Hashtable<Character, Integer> mapString(String s) {
        Hashtable<Character, Integer> map = new Hashtable<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        return map;
    }
}
