package InterviewCake.StacksQueues.Parentheticals;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(findParenthetical("Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.", 10));
    }

    // Write a method that, given a sentence like the one above, along with the position of an opening parenthesis, finds the corresponding closing parenthesis.
    static int findParenthetical(String sentence, int openingParenIndex) {
        // keep count of how many additional '(' we have
        int openNestedParens = 0;

        // for (10 + 1) - start at the element after
        for (int position = openingParenIndex + 1; position < sentence.length(); position++) {
            char c = sentence.charAt(position);

            if (c == '(') {
                openNestedParens++;
            } else if (c == ')') {
                // if 0, we've found our match
                if (openNestedParens == 0) {
                    return position;
                } else {
                    // when we find a ')' decrement
                    openNestedParens--;
                }
            }
        }

        throw new IllegalArgumentException("No closing parenthesis :(");
    }
}
