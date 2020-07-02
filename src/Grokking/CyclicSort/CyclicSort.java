package Grokking.CyclicSort;

public class CyclicSort {
    public static void main(String[] args) {
        sortInPlace(new int[] {2, 6, 4, 3, 1, 5});
       // sortInPlace(new int[]{1, 4, 3, 2});
    }

    static int sortInPlace(int[] num) {
        // current index element
        int i = 0;
        int swaps = 0;
        while (i < num.length) {
            // correct index - where the num[i] element should be
            int j = num[i] - 1;
            // if the current number we are iterating is not at the correct index
            if (num[i] != num[j]) {
                //swap it with the number at its correct index
                swap(num, i, j);
                swaps++;
            } else {
                i++;
            }
        }

        return swaps;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
