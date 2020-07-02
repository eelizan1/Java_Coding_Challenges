package DataStrucutreandAlgorithmsinJava;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1, 0, 1, 1, 1};
        System.out.println(niaveMaxNumberConsecutive(array));
    }

    // Given an binary array, find the max number of consecutive 1's
    // return an integer containing the max number
    // [1, 1, 0, 1, 1, 1] => return 3
    static int maxNumberConsecutive(int[] nums) {
        int globalMax = 0;
        int localMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                localMax++;
            } else {
                globalMax = Math.max(localMax, globalMax);
                localMax = 0;
            }
        }

        return Math.max(localMax, globalMax);
    }

    // Given an binary array, find the max number of consecutive 1's
    // return an integer containing the max number
    // [1, 1, 0, 1, 1, 1] => return 3
    static int niaveMaxNumberConsecutive(int[] array) {
        int max = 0;
        // [1, 0, 1, 1, 1]
        for(int i = 0; i < array.length; i++) {
            // the first occurence of 1
            if (array[i] == 1) {
                int currentLength = 1;
                // the next index value
                int r = i + 1;
                // the while loop to gather the remaining consecutive 1's
                // while there's still elements in array and while r = 1
                while (r < array.length && array[r] == 1) {
                    r++;
                    currentLength++;
                }
                max = Math.max(max, currentLength);
            }
        }

        return max;
    }
}
