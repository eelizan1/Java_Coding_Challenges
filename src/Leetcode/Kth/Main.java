package Leetcode.Kth;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(kthLargest(new int[] {3,2,1,5,6,4}, 2));
    }

    // Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
    static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHead = new PriorityQueue<>();
        for(int i : nums) {
            minHead.add(i);
            if (minHead.size() > k) {
                minHead.remove();
            }
        }

        return minHead.remove();
    }


}
