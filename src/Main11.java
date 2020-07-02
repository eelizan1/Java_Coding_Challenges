import java.util.*;

public class Main11 {
    public static void main(String[] args) {
        //System.out.println(integersThatMultiplyToTarget(new int[] {2, 4, 1, 6, 5, 40, -1}, 20));
        //System.out.println(findMostCommon(new int[] {1, 3, 3, 3, 1, 3, 2, 1, 5, 5, 5, 5, 5}));
        System.out.println(commonElementsRefined(new int[]{1, 3, 4, 6, 7, 9}, new int[]{1, 2, 4, 5, 9, 10}));
        //System.out.println(isRotation(new int[] {1, 2, 3, 4, 5, 6, 7},new int[] {4, 5, 6, 7, 8, 1, 2, 3} ));
       // System.out.println(nonRepeatingCharacter("aafbb"));
    }

    // find two integers that multiply to the target number
    static int[] integersThatMultiplyToTarget(int[] array, int target) {
        int[] result = new int[2];
        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        // key: index value
        // value: actual number
        for(int i = 0; i < array.length; i++) {
            // 10 = 20 / 2
            int multipliedNumber = target / array[i];
            if (hashtable.containsKey(multipliedNumber)) {
                result[0] = multipliedNumber;
                result[1] = array[i];
            } else {
                hashtable.put(array[i], i);
            }
        }
        return result;
    }

    // Find the most commonly occuring item in the array
    static int findMostCommon(int[] array) {
        int item = 0;
        int count = -1;
        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        for(int i = 0; i < array.length; i++) {
            if (hashtable.containsKey(array[i])) {
                int value = hashtable.get(array[i]) + 1;
                hashtable.put(array[i], value);
            } else {
                hashtable.put(array[i], 1);
            }


            if (hashtable.get(array[i]) > count) {
                count = hashtable.get(array[i]);
                item = array[i];
            }
        }
        return item;
    }

    // Implement your solution below.
    public static Integer mostFreqent(int[] givenArray) {
        Integer maxCount = -1; Integer maxItem = null;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i : givenArray) {
            if (count.containsKey(i)) {
                Integer newVal = count.get(i) + 1;
                count.put(i, newVal);
            } else {
                count.put(i, 1);
            }
            if (count.get(i) > maxCount) {
                maxCount = count.get(i);
                maxItem = i;
            }
        }
        return maxItem;
    }

    // Find the common elements in two sorted array
    // Better solution:
    // Traverse the two arrays simultanously (while loop and pointers)
    // if pointers equal to each other, put that element in the result array
    // If one pointer is less than the other pointer, increment the lesser pointer only
    // compare again
    static ArrayList commonElementsRefined(int[] array1, int[] array2) {
        // pointers for the array
        int p1 = 0;
        int p2 = 0;
        ArrayList common = new ArrayList();

        // traverse the two arrays
        while(p1 < array1.length && p2 < array2.length) {
            // if they are equal put in arraylist
            if (array1[p1] == array2[p2]) {
                common.add(array1[p1]);
                p1++;
                p2++;
            }

            // increment the lesser element
            else if (array1[p1] < array2[p2]) {
                p1++;
            }

            else {
                p2++;
            }
        }

        return common;
    }

    // Find the common elements in a sorted array
    static ArrayList commonElements(int[] array1, int[] array2) {
       ArrayList list = new ArrayList();
        ArrayList common = new ArrayList();
        for (int i : array1) {
            list.add(i);
        }

        for (int i : array2) {
            if (list.contains(i)) {
                common.add(i);
            }
        }
        return common;
    }

    // given two array check if one is a rotation of the other
    static boolean isRotation(int[] array1, int[] array2) {
        // check if they're the same length and if not then they're not the same
        // pick an item (first item) and see if it's array, if not then there is no rotation

        int num = array1[0];
       // int gap = 0;
        int p1 = 0;
        int p2 = -1;
        for (int i = 0; i < array2.length; i++) {
           if (array2[i] == num) {
               p2 = i;
               break; // break if same element if found in array2
           }
        }

        if (p2 == -1) {
            return false;
        }

        //
        for (int i = 0; i < array1.length - 1; i++) {
            // j = 5 % 0 = 5
            int j = (p2 + i) % array1.length;
            // elment at 0 != arra2[3]
            if(array1[i] != array2[j]) {
                return false;
            }
        }
        return true;
    }

    /*
    * Strings
    * */

    // Non repeating charachter in O(n)
    // implement a function that takes a string
    // and returns a character that only appears once
    static char nonRepeatingCharacter(String str) {
        char ch = 0;
        int count = 0;
        char[] charArray = new char[str.length()];
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        // Copy character by character into array
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }

        for (int i = 0; i < charArray.length; i++) {
            if (!hashtable.containsKey(charArray[i])) {
                hashtable.put(charArray[i], 1);
            } else {
                int round = hashtable.get(charArray[i]) + 1;
                hashtable.put(charArray[i], round);
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if(hashtable.get(charArray[i]) == 1) {
                ch = charArray[i];
                break;
            }
        }

        return ch;
    }

   static boolean valid(String s) {
        char[] array = s.toCharArray();

        int lastIndexOccurenceOfA = 0;
        int lastIndexOccurenceOfB = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'a') {
                lastIndexOccurenceOfA = array[i];
            }

            if (array[i] == 'b') {
                lastIndexOccurenceOfB = array[i];
            }
        }

        if (lastIndexOccurenceOfA > lastIndexOccurenceOfB) {
            return false;
        }

        return true;
   }
}
