package InterviewCake;

import Leetcode.ListNode;

import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] originalArray = new int[]{2, 3, 4, 5};
        squareArrayInPlace(originalArray);
        System.out.println("original array: " + Arrays.toString(originalArray));
    }

    // Array slicing
    static int[] arraySlice(int[] arr) {
        return Arrays.copyOfRange(arr, arr.length/2, arr.length);
    }

    // traversing a linkedlist
    static class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
        }
    }

    static Node getItem(Node head, int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("i can't be negative: %d", i));
        }

        // the vehical to traverse the list
        Node currentNode = head;
        // counter to increment the position in the list
        int currentPosition = 0;

        while (currentNode != null) {
            // check if current node is i
            if (currentPosition == i) {
                // found it
                return currentNode;
            }
            // if not move to next node
            currentNode = currentNode.next;
            currentPosition++;
        }
        throw new IllegalArgumentException(String.format("List has fewer than i + 1 (%d) nodes", i + 1));
    }

    static void squareArrayInPlace(int[] intArray) {

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] *= intArray[i];
        }

        // NOTE: no need to return anything - we modified
        // intArray in place
    }

    static int[] squareArrayOutOfPlace(int[] intArray) {

        // we allocate a new array with the length of the input array
        int[] squaredArray = new int[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            squaredArray[i] = (int) Math.pow(intArray[i], 2);
        }

        return squaredArray;
    }

}
