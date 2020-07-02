package InterviewCake.Arrays.ReverseLetters;

public class Main {
    public static void main(String[] args) {
        char[] charArray = {'A', 'B', 'C', 'D'};
        System.out.println(reverseInPlace(charArray));
    }

    // Write a method that takes an array of characters and reverses the letters in place.
    // The goal of this question is to practice manipulating strings in place. Since we're modifying the input, we need a mutable ↴ type like an array, instead of Java's immutable strings.
    static char[] reverseInPlace(char[] arrayOfChars) {
        // [A, B, C, D]
        int p1 = 0; // start: A
        int p2 = arrayOfChars.length-1; // start: D
        int n = arrayOfChars.length / 2; // 2

        while (p1 <= arrayOfChars.length/2 && p2 >= arrayOfChars.length/2) {
            char tempp1 = arrayOfChars[p1];
            char tempp2 = arrayOfChars[p2];
            // arr[0] = d
            arrayOfChars[p1] = tempp2;
            arrayOfChars[p2] = tempp1;
            p1++;
            p2--;
        }

        return arrayOfChars;
    }
}
