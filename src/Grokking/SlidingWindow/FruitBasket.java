package Grokking.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {
    // what this problem really is - find the longest subarray that is at most k elements
    public static void main(String[] args) {
        System.out.println(longestLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
    }

    static int longestLength (char[] arr)  {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            int occ = fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1;
            fruitFrequencyMap.put(arr[windowEnd], occ);
            // shrink the sliding window, until we are left with '2' fruits in the frequency map
            while (fruitFrequencyMap.size() > 2) {
                // update the hashmap since we are incrementing the windowStart
                // subtract occurence and/or remove character
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

//    static int totalFruit (int[] tree) {
//
//        // null check
//        if (tree == null || tree.length == 0) {
//            return 0;
//        }
//
//        int max = 1;
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int i = 0;
//        int j = 0;
//
//        while(j < tree.length) {
//            if(map.size() <= 2) {
//                map.put(tree[j], j++);
//            }
//
//            if(map.size() > 3) {
//
//            }
//        }
//    }
}
