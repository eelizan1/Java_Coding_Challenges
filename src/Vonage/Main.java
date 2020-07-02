package Vonage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
       System.out.println(getCommonMinimumNumber2(new int[] {-3, 7, -5, 82, -22}, new int[]{-8, -5, 12, 33, 7, -42}));
        //System.out.println(compare(new String[] {"abc", "123"}));
       // System.out.println(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }

    //Write a program to get the common minimum number between two arrays
    //It returns -999, when there is no common number
    static int getCommonMinimumNumber(int array1[], int array2[]) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        // pointers for the array
        int num = 0;
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> common = new ArrayList();

        // traverse the two arrays
        while(p1 < array1.length && p2 < array2.length) {
            // if they are equal put in arraylist
            if (array1[p1] == array2[p2]) {
                common.add(array1[p1]);
                p1++;
                p2++;
            }

            // increment the lesser element
            else if (array1[p1] < array2[p2]) {
                p1++;
            }

            else {
                p2++;
            }
        }

        num = common.get(0);
        for (int i = 0; i < common.size(); i++) {
            if (common.get(i) < num) {
                num = common.get(i);
            }
        }

        return num;
    }

    // Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    // For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.
    // O(n) complexity
    static int consecutive(int[] array) {
        int num = 0;

        Arrays.sort(array); // [1, 2, 3, 4, 100, 200]
        int beginningIndex = 0;
        int currentMaxLength = 0;
        for(int i = 0; i < array.length-1; i++) {
            int expected = array[i] + 1;
            if (array[i+1] != expected) {
                currentMaxLength = beginningIndex + i;
                beginningIndex = array[i+1];
            }
        }

        return currentMaxLength;
    }

    static int getCommonMinimumNumber2(int array1[], int array2[]) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int globalMin = 0;

        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                int current = array1[i];
//                if (globalMin > current) {
//                  globalMin = current;
//                }
                globalMin = Math.min(globalMin, current);
                i++;
                j++;
            } else if (array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return globalMin;

    }

    //Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    //
    //Your algorithm should run in O(n) complexity.
    static int longestConWritsecutive(int[] nums) {
        // use a set for O(1) lookup
        HashSet<Integer> num_set = new HashSet<Integer>();
        // add all elements to the set
        for (int num : nums) {
            num_set.add(num);
        }

        // keep track of the longest streak
        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                // establish local next expected num and local streak count
                int currentNum = num;
                int currentStreak = 1;

                // while set contains the next element of supposed streak
                while (num_set.contains(currentNum+1)) {
                    // increment the current expected num
                    currentNum++;
                    // increment streak
                    currentStreak++;
                }

                // compare streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int globalStreak = 0;
        for (int item : nums) {
            set.add(item);
        }

        for (int i = 0; i < nums.length; i++) {
            // check if there's one before it
            if (!set.contains(nums[i]-1)) {
                int localStreak = 1;
                int currentNum = nums[i];
                // look for after
                while (set.contains(currentNum+1)) {
                    currentNum++;
                    localStreak++;
                }

                globalStreak = Math.max(localStreak, globalStreak);
            }
        }

        return globalStreak;
    }

    //Write a function that given string S consisting of N letters a and or b returns trye when all occurneces of letter 'a' are before all occurneces of letter 'b' and returns false otherwise
    // aabbb = true
    // ba = false
    // aaa = true b doest not have to occur
    // b = true a does not have to occur
    // abba = false
    static boolean valid(String s) {
        char[] array = s.toCharArray();

        int lastIndexOccurenceOfA = -1;
        int lastIndexOccurenceOfB = -1;
        int bCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'a') {
                lastIndexOccurenceOfA = i;
            }

            if (array[i] == 'b') {
                lastIndexOccurenceOfB = i;
                bCount++;
            }
        }

        if (lastIndexOccurenceOfA > lastIndexOccurenceOfB && bCount > 0) {
            return false;
        }

        return true;
    }

    static boolean compare(String[] array) {
        String previous = ""; // empty string: guaranteed to be less than or equal to any other

        for (final String current: array) {
            if (current.compareTo(previous) < 0)
                return true;
            previous = current;
        }

        return false;
    }
}
