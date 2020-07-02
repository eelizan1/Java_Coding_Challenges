package NonProblems;

public class Main {
    public static void main(String[] args) {

    }

    static boolean BinarySearchIterative(int[] array, int x) {
        // first element
        int left = 0;
        // last element
        int right = array.length - 1;

        while (left <= right) {
            // get mid point
            int mid = left + ((left + right) / 2);
            // if middle is what we're looking for
            if (array[mid] == x) {
                return true;
            } else if (x < array[mid]) {
                // if x is on the left side
                right = mid - 1;
            } else {
                // if x is on the right side
                left = mid + 1;
            }
        }

        return false;
    }

    static boolean BinarySearchRecursively(int[] array, int x, int left, int right) {
        // error can't find
        if (left > right) {
            return false;
        }

        // get mid point
        int mid = left + ((left + right) / 2);
        // if middle is what we're looking for
        if (array[mid] == x) {
            return true;
        } else if (x < array[mid]) {
            // if x is on the left side
            return BinarySearchRecursively(array, x, left, mid-1);
        } else {
            // if x is on the right side
            return BinarySearchRecursively(array, x, mid+1, right);
        }
    }
}
