package InterviewCake.Arrays.ReverseWords;

public class Main {
    public static void main(String[] args) {

    }

    static char[] reverseWords(char[] words) {
        // first we reverse all the characters in the entire message array
        // this gives us the right word order
        // but with each word backward
        reverseCharacters(words, 0, words.length-1);

        // first we reverse all the characters in the entire message array
        // this gives us the right word order
        // but with each word backward
        int currentWordStartIndex = 0;
        // loop through
        for(int i = 0; i <= words.length; i++) {
            // found the end of the current word so stop and reverse the word
            // use the space
            if (i == words.length || words[i] == ' ') {
                // use the reverseCharacters function to reverse this subset
                reverseCharacters(words, currentWordStartIndex, i-1);
                // update the start of the currentWordStartIndex
                // add + 1 because i is stopped at a space and the next character is i + 1
                currentWordStartIndex = i + 1;
            }
        }

        return words;
    }

    static void reverseCharacters(char[] message, int leftIndex, int rightIndex) {

//        int leftIndex = 0;
//        int rightIndex = message.length - 1;

        // walk towards the middle, from both sides
        while (leftIndex < rightIndex) {

            // swap the left char and right char
            char temp = message[leftIndex];
            message[leftIndex] = message[rightIndex];
            message[rightIndex] = temp;
            leftIndex++;
            rightIndex--;

        }
    }
}
