package Grokking.CyclicSort;

import java.util.HashSet;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {4, 0, 3, 1}));
    }

    static int missingNumberWithSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i : nums) {
            hashSet.add(i);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }

        return nums.length;
    }

    static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        // find the first number missing from its index, that will be our required number
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return nums.length;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
