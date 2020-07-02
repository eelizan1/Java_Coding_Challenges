package MasterCodingInterviewJavaPythonCourse;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //RemoveElement(new int[] {3, 2, 2, 3}, 3);
        mergeSortedArray(new int[] {1, 2, 3, 0, 0, 0}, new int[] {2, 5, 6});
    }

    // Remove element in array in place and return new length
    // Do not allocate extra space for another array so O(1)
    // [3, 2, 2, 3], val = 3 => returns 2
    static int RemoveElement(int[] array, int val) {

        int index = 0;
        for(int i = 0; i < array.length; i++) {
            // if element is not the value
            // then swap current index with the non matching value
            if (array[i] != val) {
                array[index] = array[i];
                index++;
            }
        }
        return index;
    }

    // Given two sorted integer arrays nums1 and nums2, merger nums2 into nums1 as one sorted array
    // nums1: [1, 2, 3, 0, 0, 0] m=3
    // nums2: [2, 5, 6] n=3
    // output: [1, 2, 2, 3, 5, 6]
    static int[] mergeSortedArray(int[] array1, int[] array2) {
        // m and n are non zero values
      int i = 3 - 1; // start at element 3 - last non zero
      int j = 3 - 1; // start at element 6 - last non zero
      int k = 6  - 1;

      // because i and j = 2
        // need >= because there are three numbers to traverse in either array
      while (i >= 0 && j >= 0) {
          if(array1[i] > array2[j]) {
              array1[k] = array1[i];
              i--;
          } else  {
              array1[k] = array2[j];
              j--;
          }
          k--;
        }

      // copy the remaining of the second array
        while ( j >= 0) {
            array1[k] = array2[j];
            j--;
            k--;
        }
        return array1;
    }

    // Reverse words in a string
    // Given an input string, reverse the string word by word
    // ["t", "h", "e", " ", "s", "k", "y", " ", "i", "s", " ", "b", "l", "u", "e"]
    // [blue is sky the]
//    static String ReverseWord(char[] str, int start, int end) {
//
//    }
}
