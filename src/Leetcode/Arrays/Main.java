package Leetcode.Arrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      //  System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
      //  System.out.println(maxProductArray(new int[]{2, 3, -2, 4}));
        System.out.println(removeDups(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    static int maxSubArray(int[] array) {
        int globalMax = array[0];
        int localMax = array[0];

        // if array just contains negative numbres or one value
        int max = Arrays.stream(array).max().getAsInt();
        if (max < 0) {
            return max;
        }
        // loop through array
        // compare localmax with localmax + next index
        // grab the largest sum and set localmax to that sum
        // compare globalmax with localmax and set largest sum to global max
        for (int i = 0; i < array.length; i++) {
            localMax = localMax + array[i];

            globalMax = Math.max(globalMax, localMax);

            // have this check because global max is always 0
            // it wont help if localmax is less than global max
            // we want fina a potential sum that's greater than global max
            if (localMax < 0) {
                localMax = 0;
            }
        }
        return globalMax;
    }

    static int maxProductArray(int[] nums) {
        // the table that stores the latest max's
         int[] table = new int[nums.length];
         int max = nums[0];
         table[0] = nums[0];

         for (int i = 1; i < nums.length; i++) {
             table[i] = Math.max(nums[i], nums[i] * table[i - 1]);
             max = Math.max(max, table[i]);
         }
         return max;
    }

    //remove dups from array
    static int removeDups(int[] array) {
        // [1, 1, 2]
        int index = 1;
        for (int i = 0; i < array.length -1; i++) {
            if (array[i] != array[i+1]) {
                // 1, 2, 2
                array[index] = array[i + 1];
                // 2
                index++;
            }
        }

        return index;
    }

    static int removeDups2(int[] num) {
        // keep track of the number of unique items
        int index = 1;

        for (int i = 0; i < num.length -1; i++) {
            if (num[i] != num[i+1]) {
                num[index] = num[i+1];
                index++;
            }
        }
        return index;
    }
}
