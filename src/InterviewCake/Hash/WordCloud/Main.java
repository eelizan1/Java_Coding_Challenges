package InterviewCake.Hash.WordCloud;

import java.sql.SQLOutput;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        System.out.println(wordCloud("Hello hello my name is boy boy"));
    }

    //You want to build a word cloud, an infographic where the size of a word corresponds to how often it appears in the body of text
    //Write code that takes a long string and builds its word cloud data in a hash map ↴ , where the keys are words and the values are the number of times the words occurred
    static Hashtable wordCloud(String s) {
        Hashtable<String, Integer> hashtable = new Hashtable();
        // string array
        // turn s into an array of string
        String[] words = s.split("\\s+");

        // loop through array and put the words in the hashmap
        // if word is already in the map, increase count by 1
        for (int i = 0; i < words.length; i++) {
            if (hashtable.containsKey(words[i])) {
                int currentCount = hashtable.get(words[i])+1;
                String substring = words[i].substring(1, words[i].length()-1);
                hashtable.put(substring, currentCount);
            } else {
                hashtable.put(words[i], 1);
            }
        }

        return hashtable;
    }
}
