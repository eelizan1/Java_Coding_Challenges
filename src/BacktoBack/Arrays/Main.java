package BacktoBack.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    // three sum
    List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outputArray = new LinkedList<>();

        // length-2 to have a chance to look at the last two elements after since wer're looking for 3 numbers
        for (int i = 0; i < nums.length; i++) {
            // handle dups by skipping
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i + 1; // next index
                int high = nums.length-1;
                int sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        // pass in list to the the return list
                        outputArray.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        // avoid duplicates
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return outputArray;
    }
}
