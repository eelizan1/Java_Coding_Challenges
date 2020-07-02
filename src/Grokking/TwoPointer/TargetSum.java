package Grokking.TwoPointer;

public class TargetSum {
    // Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

    public static void main(String[] args) {
        int[] result = tagetSum(new int[] {1, 2, 3, 4, 6}, 6);
        for (int num: result
             ) {
            System.out.println(num);
        }
    }

    static int[] tagetSum(int[] array, int target) {
        // 1, 2, 3, 4, 5, 6

        int[] result = new int[2];
        int p1 = 0;
        int p2 = array.length - 1;

        while (p1 < p2) {
            int sum = array[p1] + array[p2];
            if (sum == target) {
                result[0] = p1;
                result[1] = p2;
                return result;
            // sum is greater, decrease top pointer
            } else if (sum > target) {
                p2--;
            } else {
                // sum is less, increase bottom pointer
                p1++;
            }
        }

        return result;
    }
}
