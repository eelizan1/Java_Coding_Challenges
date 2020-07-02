package Grokking.TwoPointer;

import java.util.Arrays;

public class squaredSorted {
    public static void main(String[] args) {
        squareArray(new int[]{-2, -1, 0, 2, 3});
    }

    static int[] squareArray(int[] array) {
        int p1 = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(array[i], 2);
        }

        Arrays.sort(array);

        return array;
    }
}
