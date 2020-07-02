package Grokking.TopK;

import java.util.*;

public class KFrequent {
    public static void main(String[] args) {
        getKTopFrequent(new int[] {1, 3, 5, 12, 11, 12, 11}, 2);
    }

    static Map<Integer, Integer> getKTopFrequent(int nums[], int k) {
        List<Integer> result = new ArrayList<>();
        // find the frequency of each number
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : nums)
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);

        // create the heap structure of the map type
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(
                (e1, e2) -> e1.getValue() - e2.getValue());

        // push map values into the heap
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return numFrequencyMap;
    }
}
