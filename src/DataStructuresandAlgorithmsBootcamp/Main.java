package DataStructuresandAlgorithmsBootcamp;

public class Main {
    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.addFront(1);
//        list.addFront(2);
//        list.addFront(3);
//        list.addFront(4);
//        list.addFront(5);
//        // 5, 4, 3, 2, 1
//        System.out.println(list);

        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(array.length); // n = 6
        System.out.println(array.length-1); // n = 5
        for(int i = 0; i < array.length-1; i++) {
            System.out.println(i + ": " + array[i]);
        }

    }

    // Nth element of a linked list
    // Given a linked list, find the element starting from the end of the list
    // solution(list, 3) -> return the 3rd element from the end
    // Implement your function below.
    public static LinkedList.Node nthFromLast(LinkedList.Node head, int n) {
        LinkedList.Node left = head;
        LinkedList.Node right = head;

        // First, make sure that we have at least n items in the linked list.
        for (int i = 0; i < n; i++) {
            if (right == null) return null;
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        return left;
    }

    // Minimum number of swaps that are required to sort an array
    // We are allowed to swap any two elements
    // We need to find the minimum number of swaps to sort the array
    // [1, 4, 3, 2] =>
}


