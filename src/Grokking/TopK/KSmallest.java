package Grokking.TopK;

import java.util.PriorityQueue;

public class KSmallest {
    public static void main(String[] args) {

    }

    static int kSmallest(int nums[], int k) {
        // priority queue
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // add elements in queue
        for(int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }

        // loop through and use a max heap
        for(int i = k; i < nums.length; i++) {
            // max heap fashion
            if(nums[i] < heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }

        return heap.peek();
    }
}
