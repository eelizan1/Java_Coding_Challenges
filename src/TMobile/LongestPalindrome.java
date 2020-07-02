package TMobile;

public class LongestPalindrome {
    public static void main(String[] args) {

    }

    // returning a string
    static String longestPalindrome(String s) {
        // starting and ending boundry to grab a final substring to return from
        int start = 0;
        int end = 0;

        // handle two cases
        for (int i =0; i < s.length(); i++) {
            // "racecar - where there's just one middle letter
            int len1 = expandFromMiddle(s, i, i);
            // "aabbaa" check the 'b' then the other 'b'
            int len2 = expandFromMiddle(s, i, i+ 1);

            // max of the lengths
            int maxLength = Math.max(len1, len2);

            // setting out boundries of the NEW palondrome substring
            if (maxLength > end - start) {
                start = i - ((maxLength-1)/2);
                end = i + (maxLength/2);
            }
        }
        return s.substring(start, end);
    }

    static int expandFromMiddle(String s, int left, int right) {
        // "abba"
        // left = index: 1
        // right = index: 2
        // while there's items in string AND while left char equals right char
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // when it breaks from while loop we've reached unmatched char with right and left
        // "acbbac"
        return right - left - 1;
    }
}
