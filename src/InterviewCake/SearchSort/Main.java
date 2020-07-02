package InterviewCake.SearchSort;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(23/8);
    }

    // binary search
    static int binarySearch(int[] array, int target) {
        int floor = -1;
        int ceiling = array.length;

        // floor + 1 is to iterate until cieling is hit
        while (floor + 1 < ceiling) {
            // get middle
            // distance will always be chancing becuase cieling and floor will be changing
            int distance = ceiling - floor;
            int halfDistance = distance / 2;
            // guess index used to shift either the ceiling down or floor up
            int guessIndex = floor + halfDistance;

            int guessValue = array[guessIndex];

            // if half way is target
            if (guessIndex == target) {
                return guessIndex;
            }

            if (guessValue > target) {

                // target is to the left, so move ceiling to the left
                // when ceiling is the guess index, the size is cut
                ceiling = guessIndex;

            } else {

                // target is to the right, so move floor to the right
                // when floor is the guess index, the size is cut
                floor = guessIndex;
            }
        }

        return -1;
    }

    //Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
    static int findDuplicate(int[] nums) {

        // [1, 4, 6, 6, 6, 2, 3]

        // find a number that appears more than once
        // use pointers
        int slow_pointer = nums[0]; // 1
        // will go twice as fast
        int fast_pointer = nums[0]; // 1

        // one step at a time
        slow_pointer = nums[slow_pointer]; // 4
        // two steps at a time
        fast_pointer = nums[nums[fast_pointer]]; // nums[nums[1]] => nums[4] => 6

        // if there's a cylce, there's going to be an intersection
        // that intersection will be the spot where the duplicate is
        while (slow_pointer != fast_pointer) {
            // one step at a time
            slow_pointer = nums[slow_pointer]; // nums[4] => 6
            // two steps at a time
            fast_pointer = nums[nums[fast_pointer]]; // nums[nums[6]] => nums[3] => 6
        }

        // once intersection point found - we know there's a cycle but not where just yet
        int a_pointer = nums[0]; // 1
        int b_pointer = slow_pointer; // 1

        while (a_pointer != b_pointer) {
            a_pointer = nums[a_pointer]; // nums[1] => 4
            b_pointer = nums[b_pointer]; // nums[1] => 4
        }

        // return 4 which is the index of the duplicate
        return a_pointer;

    }
}
