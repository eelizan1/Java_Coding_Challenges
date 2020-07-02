package Leetcode.FizzBuzz;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(fizzBuzzHash(20));
    }
    static List<String> fizzBuzz(int n) {
        // ans list
        List<String> ans = new ArrayList<String>();

        for (int num = 1; num <= n; num++) {

            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);

            String numAnsStr = "";

            if (divisibleBy3) {
                // Divides by 3, add Fizz
                numAnsStr += "Fizz";
            }

            if (divisibleBy5) {
                // Divides by 5, add Buzz
                numAnsStr += "Buzz";
            }

            // if num hasn't been concatenated by 3 or 5 then it's not divisible by 3 or 5
            if (numAnsStr.equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }

            // Append the current answer str to the ans list
            ans.add(numAnsStr);
        }

        return ans;
    }

    static List<String> fizzBuzzHash(int n) {
        ArrayList<String> list = new ArrayList<>();
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(3, "Fizz");
        hashtable.put(5, "buzz");

        for (int i = 1; i <= n; i++) {
            String output = "";
            for(Integer item: hashtable.keySet()) {
                if (i % item == 0) {
                    output += hashtable.get(item);
                }
            }

            if (output.equals("")) {
                output += Integer.toString(i);
            }

            list.add(output);
        }

        return list;
    }
}
