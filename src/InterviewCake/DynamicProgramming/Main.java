package InterviewCake.DynamicProgramming;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(fib(5));
        //System.out.println(getPermutations("home").size());
    }

    static int fib(int n) {
        // because n will keep getting smaller,
        // eventually n will be 0 or 1
        if (n == 0 || n == 1) {
            return n;
        }
        // n will keep getting smaller from n-1 and n-2
        // sum of the two previous ones of n
        return fib(n-1) + fib(n-2);
    }

    static int fibWithTable(int n) {
        Hashtable<Integer, Integer> table = new Hashtable<>();

        if (n == 0 || n == 1) {
            return n;
        }

        // edge case: negative index
        if (n < 0) {
            throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");
        }

        int result = fib(n -1) + fib(n - 2);
        table.put(n, result);

        return result;
    }

    //Write a recursive method for generating all permutations of an input string. Return them as a set.
    // If we're making all permutations for "cat," we take all permutations for "ca" and then put "t" in each possible position in each of those permutations. We use this approach recursively:
    // this is a backtracking problem 
    static Set<String> getPermutations(String inputString) {

        // base case
        // return the list of just the one element or none
        if (inputString.length() <= 1) {
            return new HashSet<>(Collections.singletonList(inputString));
        }

        // get all characters except last character "home"
        // hom -> ho -> h
        String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
        // get last character in the string
        // e -> m -> o -> h
        char lastChar = inputString.charAt(inputString.length() - 1);

        // recursive call: get all possible permutations for all chars except last
        Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

        // put the last char in all possible positions for each of the above permutations
        Set<String> permutations = new HashSet<>();
        for (String permutationOfAllCharsExceptLast : permutationsOfAllCharsExceptLast) {
            for (int position = 0; position <= allCharsExceptLast.length(); position++) {
                String permutation = permutationOfAllCharsExceptLast.substring(0, position) + lastChar
                        + permutationOfAllCharsExceptLast.substring(position);
                permutations.add(permutation);
            }
        }

        return permutations;
    }
}
