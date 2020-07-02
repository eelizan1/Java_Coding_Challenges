package DataStructuresandAlgorithmsBootcamp;

public class LinkedList {
    // head of the linkedlist
    private Node head;
    private int size;

    // the class that stores the information and the pointer to next node
    // used by head, tail, and other nodes
    public static class Node {
        int data;
        // pointer to next node in our list
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // add front node
    // FIRST IN LAST OUT (LIFO) like a stack
    public void addFront(int data) {
        Node newNode = new Node(data);

        // check to see if we added any before and if not, add it after head
        if (head == null) {
            head = newNode;
            return;
        }

        // if there are nodes after the head
        // set it's next to the current head
        newNode.next = head;

        // set current head to be new head
        // have current head point to new node
        head = newNode;

        size++;
    }

    // public int get first node
    // first element will always be the head
    public int getFirst() {
        return head.data;
    }

    // get last element
    public int getLast() {
        // start at the head and traverse the list until you reach the tail
        Node current = head;

        // the end of the list is when next is null
        while (current.next != null) {
            current = current.next; // O(n)
        }

        // at tail
        return current.data;
    }

    // add to the end of list O(n)
    public void addBack(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        // start at the head
        Node current = head;

        // walk back until node = null
        while (current.next != null) {
            current = current.next; // O(n)
        }

        //last node = new node
        // points the previous last node to the new last node
        current.next = newNode;

        size++;
    }

    public int returnSize() {
        return size;
    }

    // get the size of the list
    public int getSize() {
        // start at 1 because you atleast have a head
        int size = 1;

        // if list empty
        if (head == null) {
            return 0;
        }

        // start at the head
        Node current = head;

        // walk back until node = null
        while (current.next != null) {
            current = current.next; // O(n)
            size++;
        }

        return size;
    }

    // clear list
    public void clear() {
        head = null;
    }

    public void delete(int data) {
        // data is the node to delete

        // if at head
        if (head == null) {
            return;
        }

        // to delete first node after head
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        // remove value in middle of list
        while (current.next != null) {
            if (current.next.data == data) {
                // current's next's next by passes that next element
                // and has the curren'ts element point to the next's next
                current.next = current.next.next;
                return;
            }

            // keep searching
            current = current.next;
        }
    }
 }
