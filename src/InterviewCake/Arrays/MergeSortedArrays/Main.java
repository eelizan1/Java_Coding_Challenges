package InterviewCake.Arrays.MergeSortedArrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
        System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
    }

    // merge two sorted arrays
    // time: O(n)
    // space: O(n)
    // have two pointers point reference each element of the two arrays
    // compare the two pointers
    // take the lesser and increment the lesser's pointer
    // repeat
    static int[] mergeArrays(int[] a1, int[] a2) {
        // space O(1)
        int[] sorted = new int[a1.length + a2.length];

        // pointer for a1
        int i = 0;
        // pointer for a2
        int j = 0;
        // indext to track the sorted arrays
        int index = 0;
        while (index < sorted.length-1) {
            if (a1[i] < a2[j]) {
                sorted[index] = a1[i];
                i++;
            } else {
                // i > j
                sorted[index] = a2[j];
                j++;
            }
            index++;
        }

        // copy remaining elements from array 1 if there are left over
        // start where a1 is left off
        // index will be at the last inserted element in sorted array
        while (i < a1.length) {
            sorted[index++] = a1[i++];
        }

        // copy remaining elements from array 2 if there are left over
        // start where a2 is left off
        // index will be at the last inserted element in sorted array
        while (j < a2.length) {
            sorted[index++] = a2[j++];
        }

        return sorted;
    }
}
