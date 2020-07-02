package Leetcode.Bit;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println(reverseBits(16));
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);

        System.out.println(set);
        //00000010100101000001111010011100
        //00111001011110000010100101000000
    }
    static int reverseBits(int n) {
        boolean negative = n < 0;
        int ans = 0;
        for(int i = 0; i < 31; i++) {
            if((n & 1) == 1){
                ans++;
            }
            ans = ans << 1;
            n = n >> 1;
        }
        return ans = negative ? ans+1: ans;
    }

    // reverse an integer
    static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x *= -1;
        }

        // to avoid integer overflow
        long reversed = 0;
        while (x > 0) {
            // (reversed * 10 to deal with the 1s, 10th, and 100th place) + the trailing number
            reversed = (reversed * 10) + (x % 10);
            // to get next digit
            x /= 10;

            /// ex 123
            // (x % 10) will get 3
            // then 123 / 10 will give the 12
        }

        // if integer flow
        if (reversed > Integer.MAX_VALUE) {
            return 0;
        }
        return negative ? (int)(reversed * -1) : (int)reversed;
    }
}
