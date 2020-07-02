package Grokking.CyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllMissingNumbers {
    public static void main(String[] args) {
        System.out.println(findMissingNumbersWithSey(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    static List<Integer> findMissingNumbersWithSey(int nums[]) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums) {
            set.add(i);
        }

        for(int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
