package Grokking.TwoPointer;

public class removeDups {
    public static void main(String[] args) {
        //System.out.println(removeDuplicates(new int[] {2, 3, 3, 3, 6, 9, 9}));
        System.out.println(remove(new int[]{3, 2, 3, 6, 3, 10, 9, 3 }, 3));
    }

    static int removeDuplicates(int[] array) {
        // start at 1 since that first number is always unique
        // p1 is where we should place the new number if two pointers arn't equal
        int p1 = 1;
        for (int p2 = 0; p2 < array.length-1; p2++) {
            // compare side by side
            if (array[p2] != array[p2+1]) {
                // move it next to the last non-duplicate number we've seen
                array[p1] = array[p2+1];
                p1++;
            }
        }
        return p1;
    }

    static int remove(int[] arr, int key) {
        int nextElement = 0; // index of the next element which is not 'key'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }

        return nextElement;
    }

    }
