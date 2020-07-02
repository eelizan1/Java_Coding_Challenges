package Grokking.TopK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KLargetst {
    //Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
    //
    //Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.
    //
    //Example 1:
    //
    //Input: [3, 1, 5, 12, 2, 11], K = 3
    //Output: [5, 12, 11]
    //Example 2:
    //
    //Input: [5, 12, 11, -1, 12], K = 3
    //Output: [12, 11, 12]
    public static void main(String[] args) {

        System.out.println(kthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
    }

    // brute force
    static int[] kLargetstBrute(int[] array, int k) {
        int[] result = new int[array.length - k];
        int j = 0;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(array);

        // i = 3
        // length = 6;
        for(int i = k; i < array.length; i++) {
            result[j] = array[i];
            j++;
        }

        return result;
    }

    static int kthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        // min heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // add k amount of numbers into the heap
        // 0 - k elements will be in the heap
        for(int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }

        // loop through remaining elements in min heap fashion
        for(int i = k; i < nums.length; i++) {
            // > min heap fashion
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }

        // output
        return heap.peek();
    }

}
