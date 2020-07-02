package MasterCodingInterview;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Main {
    public static void main(String args[]) {
        //System.out.println(merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3));
        System.out.println(mergeSortedArrays(new int[] {1,3,4,5}, new int[] {2,6,7,8}));
    }

    // Given two array, return true or false if these arrays have an element in common
    // 2 parameters
    // return true or false
    // Use Hashtable for O(1)
    static boolean commonElementInArrays(char[] array1, char[] array2) {
        // first loop through first array  and create object where properties equal items in array
        // loop through second array and check if item in second array exists on created object
        // even though there's two loops, they're not nested resulting in O(a + b) = O(n)

        // creating a hash table to store first array O(n)
        Hashtable<Character, Boolean> hashtable = new Hashtable<Character, Boolean>();

        if (array1.length == 0 || array1.length == 0) {
            return false;
        }

        // store array items into hashtable
        for (int i = 0; i < array1.length; i++) {
            hashtable.put(array1[i], true);
        }

        // loop through the second array to see if values match valuesin hashtable
        for (int i = 0; i < array2.length; i++) {
            if (hashtable.containsKey(array2[i])) {
                return true;
            }
        }
        return false;
    }

    // Given an array, find the pair that will sum to the given number, x
    // Naive way, would be to do a nested for loop
    static boolean findSumPairNested(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    return true;
                }
            }
        }
        return false;
    }

    // Given an array, find the pair that will sum to the given number, x
    // Using pointers from beginning and end
    // [1, 2, 4, 4]
    static boolean findSumPair(int[] arr, int n) {
        // sort array - O(nlogn)
        Arrays.sort(arr);

        int beginning = 0;
        int end = arr.length-1; // get last index value

        // use a while loop have two points come together
        while (beginning < end) {
            int s = arr[beginning] + arr[end];
            if (s == n) {
                return true;
            }
            // if pair is too small move lower end up
            if (s < n) {
                beginning++;
            } else {
                // if pair is too big, move upper end down
                end--;
            }
        }
        return false;
    }

//    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    static int[] twoSum(int[] nums, int target) {
        // assumed the array given is sorted
        //Arrays.sort(nums);
        // Niave approach would be to iterate the array in O(n^2) and checking each element against each other element for a sum
        // once the sum has been found, then return the index's

        // the better apprach
        // will run in O(n)
        // Iterate the array once from the beginning and end simultaneously
        // compare the sum of the target
        // if the sum = target; return indexes
        // if the target < sum; increment the low; return indexes
        // if the target > sum; decrement the high; return indexes

        int low = 0; // start at the beginning of array
        int high = nums.length-1; // the end of the array
        int n = nums.length;
        int[] output = new int[2];

        // traverse the array from both ends
        while (low < high) {
            int sum = nums[low] + nums[high];

            if (sum == target) {
                output[0] = low;
                output[1] = high;
                return output;
            }

            if (sum < target) {
                low++;
            } else {
                high--;
            }
        }

        return output;
    }

    // two sum without the need to sort
    // total = 8
    // [1, 2, 4, 4,]
    // set = {7, 6, 4}
    static int[] twoSumNonSort(int[] array, int total) {
        // store compliments
        // creating a hash table to store first array O(n)
        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        int[] output = new int[2];
        for (int i = 0; i < array.length; i++) {
            int compliment = total - array[i];
            if (!hashtable.containsKey(compliment)) {
                // storing the compliment
                hashtable.put(array[i], i);
            } else {
                output[0] = hashtable.get(compliment);
                output[1] = i;
                return output;
            }
        }
        return output;
    }

    // reverse a string
    // note - treat string questions as arrays
    // O(n)
    static String reverseString(String s) {
        String output = "";
        for (int i = s.length() -1; i >= 0; i--) {
            output += s.charAt(i);
        }
        return output;
    }

    // merge sorted arrays
    // O(n + m) = O(n)
    static int[] mergeSortedArrays(int[] array1, int[] array2) {
        // create output array that has the size of array1 and array2
        int[] outputArray = new int[array1.length + array2.length];
        // position of array1
        int i = 0;
        // position of array2
        int j = 0;
        // used to increment and progress the output array
        int mergedPosition = 0;

        // traverse both arrays simultaniously
        while(i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
              outputArray[mergedPosition] = array1[i];
                mergedPosition++;
                i++;
            } else {
                outputArray[mergedPosition] = array2[j];
                mergedPosition++;
                j++;
            }
        }

        // copy remaining elements from array 1 if there are left over
        while (i < array1.length) {
            outputArray[mergedPosition++] = array1[i++];
        }

        // copy remaining elements from array 2 if there are left over
        while (j < array2.length) {
            outputArray[mergedPosition++] = array2[j++];
        }

        return outputArray;
    }

    // Given an array = [2, 5, 1, 2, 3, 5, 1, 2, 4]
    // return the first occurring number
    // if all unique items - return indefined
    static int findFirstOccurance(int[] array) {

        // O(n)
        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();

        // O(n)
        for (int i = 0; i < array.length; i++) {
            if (!hashtable.containsKey(array[i])) {
                hashtable.put(array[i], 1);
            } else {
                return array[i];
            }
        }
        return -1;
    }

    // Find the first and last position of Element in Sorted Array
    // Complexity should be in O(logn) -Binary Search
    static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        // these will be binary searches
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;
    }

    static int findStartingIndex(int[] nums, int target) {
        // initialize to -1 if we dont' find it
        int index = -1;

        int start = 0;
        int end = nums.length -1;

        while(start <= end) {
            // get mid point (added overflow)
            int midPoint = start + (end-start) / 2;
            // if target is on left
            // NOTE: >= because of duplicates - if no duplicate then just >
            if (nums[midPoint] >= target) {
                end = midPoint-1;
            } else {
                start = midPoint+1;
            }

            // logic of the loop
            if (nums[midPoint] == target) {
                index = midPoint; // found target
            }
        }
        return index;
    }

    static int findEndingIndex(int[] nums, int target) {
        // initialize to -1 if we dont' find it
        int index = -1;

        int start = 0;
        int end = nums.length -1;

        while(start <= end) {
            // get mid point (added overflow)
            int midPoint = start + (end-start) / 2;
            // logic of the loop
            if (nums[midPoint] <= target) {
                start = midPoint+1;
            } else {
                end = midPoint-1;
            }

            if (nums[midPoint] == target) {
                index = midPoint; // found target
            }
        }

        return index;
    }

    static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int nums1Index = 0;
        int nums2Index = 0;
        int finalIndex = 0;
        int[] finalArray = new int[n + m];

        while(nums1Index < m && nums1Index < n) {
            if (nums1[nums1Index] < nums2[nums2Index]) {
                finalArray[finalIndex] = nums1[nums1Index];
                nums1Index++;
                finalIndex++;
            } else {
                finalArray[finalIndex] = nums2[nums2Index];
                nums2Index++;
                finalIndex++;
            }
        }

        // put remaining elements in final array
        while (nums1Index < m) {
            finalArray[finalIndex++] = nums1[nums1Index++];
            // finalIndex++;
            // nums1Index++;
        }

        while (nums2Index < n) {
            finalArray[finalIndex++] = nums2[nums2Index++];
            // finalIndex++;
            // nums2Index++;
        }

        return finalArray;
    }
}
