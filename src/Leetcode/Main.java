package Leetcode;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println(twoSum(new int[] {2, 7, 11, 15}, 9));
        //System.out.println(sumOfTwoSquares(5));
        System.out.println(removeDupsFromArray(new int[] {1, 2, 3, 4, 4, 5, 6, 6}));
    }
    //Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
    //An input string is valid if:
    //
    //Open brackets must be closed by the same type of brackets.
    //Open brackets must be closed in the correct order.
    //Note that an empty string is also considered valid.
    static boolean isValidParen(String s) {

        if (s.length() == 1) {
            return false;
        }
        // convert string to array
        char[] array = s.toCharArray();
        // have stack to place characters
        Stack<Character> stack = new Stack<Character>();

        // loop through array
        int index = 0;
        while (index < array.length) {
            // if item is ')', '}', or ']'
            if (array[index] == ')' || array[index] == '}' || array[index] == ']') {
                // pop from stack
                char poppedItem = stack.pop();
                // compare if item popped is the correspinding closed bracket
               if (!stack.isEmpty() && array[index] == ')' && poppedItem != '(')
                   return false;
                if (!stack.isEmpty() && array[index] == '}' && poppedItem != '{')
                    return false;
                if (!stack.isEmpty() && array[index] == ']' && poppedItem != '[')
                    return false;
            } else {
                stack.push(array[index]);
            }
            index++;
        }
        return true;
    }
    static int brackets(String s) {
        // create stack
        Stack<Character> stack = new Stack<>();

        // start processing every character in the string s by extracting the characters into char array
        for(char c: s.toCharArray()) {
            // handle cases - check to see if char is any of the character types
            if (c == '{' || c == '[' || c == '(') {
                // push open chars to stack
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return 0;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return 0;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return 0;
            }
        }
        // check if stack is empty
        // if the stack is not empty, this means that we've reached the end of the string array cuz it would've been popped and compared
        // with no more corresponding brackets
        // if stack is empty, that means its opposite was in the array
        // ex: "{{" -> once index is at the end (for loop finished) and stack still has items, then there's no corresponding bracket
        return stack.isEmpty() ? 1 : 0;
    }
    // Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
    // Input: 1->2->4, 1->3->4
    //Output: 1->1->2->3->4->4
    // logic is - traverse both lists, and take the smallest of the two elements and add to output list (current node), then increment the pointer of the smallest element
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // the head or the start of the list
        ListNode tempNode = new ListNode(0);
        // acts as the tail node
        ListNode currentNode = tempNode;
        // traverse through both list
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                // assign current node's next node to l1 node
                currentNode.next = l1;
                // traverse l1's list to next node (incrementing)
                l1 = l1.next;
            } else {
                // assign current node to l2
                currentNode.next = l2;
                // traverse only l2
                l2 = l2.next;
            }

            // after assignment increment the current node
            // at this point current node list has values and the next current node is ready for assignment
            currentNode = currentNode.next;
        }

        // logic if one list is finished while the other is not

        // this means that l1 still has values
        if (l1 != null) {
            // put all of l1's remaining values into current node list
            currentNode.next = l1;
            // increment
            l1 = l1.next;
        }

        if (l2 != null) {
            currentNode.next = l2;
            // increment
            l2 = l2.next;
        }

        // we want to return tempNode (the head) because if we return current node, its just the latest node assigned
        // tempNode has the beginning of currentNode's list
        return tempNode.next;
    }

    //Remove Duplicates from Sorted Array
    //Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
    //Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    // Use In place algorithm with two pointer technique
    static int removeDupsFromArray(int[] array) {
        // there's atleast one unique number
        int index = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != array[i+1]) {
                // we are replacing the last common elment with the next elment since its not the same number
                // ex [1, 1, 2]
                // index 1 is now 2 => [1, 2, 2]
                array[index] = array[i+1];
                index++;
            }
        }

        // if you want to return the non duplicate list
        for (int i = 0; i < index; i++) {
            list.add(array[i]);
        }

        return index;
    }

    static ListNode reverseList(ListNode head) {

        // head is the current node

        // previous to the head
        ListNode prev = null;

        // prev = null, head = 1, next = 2
        // prev->1->2->3->4->5->NULL

        while (head != null) {
            // instantiate next node
            ListNode next_node = head.next; // 2
            head.next = prev; // from 1 to null (reverse)
            prev = head; // from null to 1
            head = next_node; // 2 (go to next node and make it current since head is current)
        }

        // return prev because head (current) becomes null at the end of the loop
        // so prev is now the new head which is the start of the list
        return prev;
    }

    // kth largest element in an array
//    static int largestElement (int[] array, int k) {
//        int n = array.length;
//        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
//
//        for(int i = 0; i < array.length; i++) {
//            int compliment = n - array[i];
//
//        }
//    }

    static int[] twoSum(int[] array, int target) {
        Hashtable<Integer, Integer> table = new Hashtable<>();

        int[] output = new int[2];
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];

            if (table.containsKey(complement)) {
                return new int[] { table.get(complement), i };
            }

            table.put(array[i], i);
        }

        return output;
    }

    // check to see if a number has the sum of two squares
    static boolean sumOfTwoSquares(int n) {
        int low = 0;
        int high = (int)Math.sqrt(n);

        while (low < high) {
            // two square sum
            int sum = low * low + high * high;
            if (sum == n) {
                return true;
            } else if (sum < n) {
                low ++;
            } else {
                high++;
            }
        }

        return false;
    }
}
