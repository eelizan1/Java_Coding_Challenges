package InterviewCake.Hash;

import java.util.HashSet;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        //System.out.println(isPermutatedPalindrome("civic"));
        System.out.println(sortedScore(new int[] {37, 89, 41, 65, 53}, 100));
    }

    // Write a method that takes an integer flightLength (in minutes) and an array of integers movieLengths (in minutes) and
    // returns a boolean indicating whether there are two numbers in movieLengths whose sum equals flightLength.
    //return true or false if there are two numbers that equal the given sum
    static boolean twoSum(int[] array, int sum) {
        HashSet<Integer> set = new HashSet<>();

        int currentCompliment = 0;
        for (int i = 0; i < array.length; i++) {
            currentCompliment = sum - array[i];
            if (set.contains(currentCompliment)) {
                return true;
            } else {
                set.add(array[i]);
            }
        }

        return false;
    }

    //Write an efficient method that checks whether any permutation ↴ of an input string is a palindrome. ↴
    // check if the string has pairs
    // while looping, if same index'ed character is in the hashset, then thats a pair
    // so remove item since it eleminates it from the unpair group
    // in the end, if the list contains more than one item, there are more than one unpaird items so non palindrome
    static boolean isPermutatedPalindrome(String s) {
       HashSet<Character> hashSet = new HashSet<>();

        char[] charArray = s.toCharArray();

        // remove pairs from set to islolate the ones with out pair
        for(char item:charArray) {
            if (hashSet.contains(item)) {
                hashSet.remove(item);
            } else {
                hashSet.add(item);
            }
        }
        // if there are more than 1 item in set, there is not palindrome
        return hashSet.size() <= 1;
    }

    //Write a method that takes:
    //
    //an array of unsortedScores
    //the highestPossibleScore in the game
    //and returns a sorted array of scores in less than O(n\lg{n})O(nlgn) time.
    // int[] unsortedScores = {37, 89, 41, 65, 91, 53};
    //final int HIGHEST_POSSIBLE_SCORE = 100;
    //
    //int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE)
    //// sortedScores: [91, 89, 65, 53, 41, 37]
    static int[] sortedScore(int[] scores, int highestPossibleScore) {
        // array of 0s at indices 0..highestPossibleScore
        int[] scoreCounts = new int[highestPossibleScore + 1];

        // populate scoreCounts
        // index will be 1 - 100
        // value will be the occurence of the index number in the scores array
        for (int score : scores) {
            scoreCounts[score]++;
        }

        // populate the final sorted array
        int[] sortedScores = new int[scores.length];
        int currentSortedIndex = 0;

        // for each item in scoreCounts
        for (int score = highestPossibleScore; score >= 0; score--) {
            int count = scoreCounts[score];

            // for the number of times the item occurs
            for (int occurrence = 0; occurrence < count; occurrence++) {

                // add it to the sorted array
                sortedScores[currentSortedIndex] = score;
                currentSortedIndex++;
            }
        }

        return scoreCounts;
    }

}
