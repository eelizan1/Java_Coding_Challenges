package Codality;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
       System.out.println(largestSubarraySum(new int[] {7, -8, 4, -1, 6, -2, 3, -6, 5}));
    }

    // find the point in the array where the left side and the right side difference
    // are at a minimum
    static int equilibrium(int[] array) {
        // get starting values of left and right sum

        // left side of array starting at index 0
        int leftSum = array[0];
        // everything else to the right;
        int rightSum = 0;
        for (int x: array) rightSum += x; // sum all the right values
        // subtract first item from leftSum; pointer at position 1
        rightSum -= leftSum;

        // first difference between left and right
        int diff = Math.abs(leftSum - rightSum);

        for(int i = 1; i < array.length; i++) {
            leftSum += array[i]; // adding iteration values to left
            rightSum -= array[i]; // subtracting iteration valies to right
            int currentDifference =  Math.abs(leftSum - rightSum);
            // if we found the a difference smaller than first diff
            if (diff > currentDifference) {
                diff = currentDifference;
            }
        }
        return diff;
    }

    // Cyclic rotation of arrays
    static int[] cyclicRotation(int[] array, int K) {
        int[] result = new int[array.length];

        // assign new values to result array
        for (int i = 0; i < result.length; i++) {
            int position = (i + K) % result.length;
            // get the location to insert in the new array and assign it the array item of i
            result[position] = array[i];
        }

        return result;
    }

    static void rotateInPlace(int[] nums, int k) {
        int[] clone = nums.clone();
        for(int i=0;i<nums.length;i++){
            nums[(i+k)%nums.length] = clone[i];
        }
    }

    // return the result array with the counters
    // n is the number of counters
    // array are the instructions
    static int[] maxCounters(int n, int[] array) {
        int[] counters = new int[n];
        // initilize counters with 0's
        Arrays.fill(counters, 0);
        int start_line  = 0;
        int current_max = 0;

        for (int i : array) {
            // because the instruction (array) starts at index 0
            // i is pointing to a counterID starting from 1 - counter is starting from 1
            int x = i - 1;
            // if first instruction is the max counter set start line to be current max
            if ( i > n) start_line = current_max;
                // if valuse of counter at position x is less than startline
                else if (counters[x] < start_line) counters[x] = start_line + 1;
                // counter is head of startline
                else counters[x] += 1;
                if ( i < n && counters[x] > current_max) current_max = counters[x];
        }
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < start_line) counters[i] = start_line;
        }
        return counters;
    }

    // Brackets problem - verify if the string contains the proper opening and corresponding brackets
    // use a stack
    static int brackets(String s) {
        // create stack
        Stack<Character> stack = new Stack<>();

        // start processing every character in the string s by extracting the characters into char array
        for(char c: s.toCharArray()) {
            // handle cases - check to see if char is any of the character types
            if (c == '{' || c == '[' || c == '(') {
                // push open chars to stack
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return 0;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return 0;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return 0;
            }
        }
        // check if stack is empty
        return stack.isEmpty() ? 1 : 0;
    }

//    static int fishSolution(int[] A, int[]B) {
//        Stack<Integer> stack = new Stack<>();
//        int survivors  =0;
//        for (int i = 0; i < A.length; i++) {
//            int weight = A[i];
//            if (B[i] == 1) {
//                stack.push(weight);
//            } else {
//                int weightDown = stack.isEmpty() ? -1 : stack.pop();
//                while(weightDown != -1 && )
//            }
//        }
//    }

    // Leader problem
    // Find the leader of an array (most occurance greater than n/2) and return the indexes of that leader
    // in O(n) time
    static int leader(int[] array) {
        int leader = 0;
        int count = 0;
        Arrays.sort(array);
        leader = array[array.length/2];
        for(int i = 0; i < array.length; i++) {
            if (array[i] == leader) {
                count++;
            }
        }
        return count;
    }

    static int leaderOptimal(int[] array) {
        int consecutiveSize = 0;
        int candidate = 0;

        for (int item: array) {
            // when stack is empty;
            if (consecutiveSize == 0) {
                consecutiveSize += 1;
            }
            // same value as item
            else if (candidate == item) {
                consecutiveSize+=1;
            } else {
                consecutiveSize -=1;
            }
        }

        // check if leader or not
        int occurrence = 0;
        int index = 0;
        for (int i = 0;  i < array.length; i++) {
            if (array[i] == candidate) {
                occurrence++;
                index = i;
            }
        }

        return occurrence > array.length / 2.0 ? index : -1;
    }

    static int count(String S) {
        // RL R RL L RL R RL L
        int Rcount = 0;
        int Lcount = 0;
        //int count_total=0;
        int count_total = ( S.split("RL", -1).length ) - 1;
        for (var i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'R') {
                Rcount++;
            } else if (S.charAt(i) == 'L') {
                Lcount++;
            }
        }

        if (Rcount == Lcount) {
            count_total++;
        }
        return count_total;
    }

    // Max profit
    // give an array of numbers (stock prices) find the max profit [buying, selling]
    // use Kadanes Algorithm
    // O(n)
    static int maxProfit(int[] array) {
        int globalMaxSum = 0;
        int localMaxSum = 0;

        // start at 1 to calculate the delta of the previous one
        for(int i = 1; i < array.length; i++) {
            // calculate delta
            int delta = array[i] - array[i-1]; // -9 = -4 + 5
            // compare with delta and localMaxSum + delta
            localMaxSum = Math.max(delta, localMaxSum + delta);
            // compare localMaxSum with globalMaxSum
            globalMaxSum = Math.max(localMaxSum, globalMaxSum);
        }

        return globalMaxSum;
    }

    // Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
    // Using the Kadane's algorithm
    static int largestSubarraySum(int[] array) {
        int globalMax = 0;
        int localMax = 0;

        // if array just contains negative numbres or one value
        int max = Arrays.stream(array).max().getAsInt();
        if (max < 0) {
            return max;
        }

        // loop through array
        // compare localmax with localmax + next index
        // grab the largest sum and set localmax to that sum
        // compare globalmax with localmax and set largest sum to global max
        for (int i = 0; i < array.length; i++) {
            localMax = localMax + array[i];
            // set new global max
            if (globalMax < localMax) {
                globalMax = localMax;
            }

            if (localMax < 0) {
                localMax = 0;
            }
        }
        return globalMax;
    }

   // Given an array nums, write a function to move all 0's to the end of it
    // while maintaining the relative order of the non-zero elements.
    // [0, 1, 0, 3, 12]
    static int[] moveZeros(int[] nums) {
        int index = 0; // the index to place the non-zero elements

        for(int i = 0; i < nums.length; i++) {
            // check for non-zero numbers
            if(nums[i] != 0) {
                // if non-zero place at index
                nums[index] = nums[i];
                // increment index for the next non-zero
                index++;
            }
        }

        // fill remainding slots of the array with 0's
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    // Prefix Sums
    // Used to sum a portion of an array
    static int[] suffixSum(int arr[]) {
        int[] output = new int[arr.length+1];
        int sum = 0;
        for (int index = 0; index < arr.length; index++) {
            output[index+1] = output[index] + arr[index];
        }

        return output;
    }
}
