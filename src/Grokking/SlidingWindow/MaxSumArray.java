package Grokking.SlidingWindow;
//Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
//
//Example 1:
//
//Input: [2, 1, 5, 1, 3, 2], k=3
//Output: 9
//Explanation: Subarray with maximum sum is [5, 1, 3].
//Example 2:
//
//Input: [2, 3, 4, 1, 5], k=2
//Output: 7
//Explanation: Subarray with maximum sum is [3, 4].
public class MaxSumArray {
    public static void main(String[] args) {
        System.out.println(buteFocefindMaxSumSubArray(2, new int[] {2, 3, 4, 1, 5}));
    }

    // brute force
    static int buteFocefindMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int n = arr.length - k; // so that the index wont go over length - k
        for (int i = 0; i < n; i++) {
            int localSum = 0;
            for(int j = i; j < i + k; j++) {
                localSum += arr[j];
            }

            maxSum = Math.max(maxSum, localSum);
        }

        return maxSum;
    }

    // sliding window
    static int maxSubArray(int k, int[] arr) {
        int maxSum = 0; // the global max sum tracker
        int windowSum = 0; // the sum that will be used for the next subarray
        int windowStart = 0; // the new start of the next subarray

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            // reached the ned of the subarray
            if (i >= k - 1) {
                // record the sum
                maxSum = Math.max(maxSum, windowSum);
                // remove going out element
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }
}
