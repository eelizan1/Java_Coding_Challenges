package TMobile;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    // remove duplicates
    static int removeDups(int[] nums) {
        // start at 1 since there's at least one unique number
        int p1 = 1;
        int p2 = 1;

        while (p2 < nums.length) {
            if(nums[p1-1] != nums[p2]) {
                nums[p1] = nums[p2];
                p1++;
            }
            p2++;
        }

        return p1;
    }

    // remove dups 2
    static int removeDups2(int[] nums) {
        Arrays.sort(nums);
        int index = 1;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[i+1]) {
                // return index
                nums[index] = nums[i+1];
                index++;
            }
        }

        return index;
    }
}
