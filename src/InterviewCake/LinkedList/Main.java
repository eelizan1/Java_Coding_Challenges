package InterviewCake.LinkedList;

public class Main {
    public static void main(String[] args) {

    }

    // delete the givin input node
    static void deleteNode(Node node) {
        Node nextNode = node.next;

        if (nextNode != null) {
            node.value = nextNode.value;
            node.next = nextNode.next;
        } else {
            // eep, we're trying to delete the last node!
            throw new IllegalArgumentException("Can't delete the last node with this technique!");
        }
    }

    // check if list has a cycle
    // A cycle occurs when a node’s next points back to a previous node in the list. The linked list is no longer linear with a beginning and end—instead, it cycles through a loop of nodes.
    static boolean hasCycle(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head.next;

        //If the linked list has a cycle, fastRunner will "lap" (catch up with) slowRunner,
        // and they will momentarily equal each other.
        while (slow != fast) {

            // we've reached the end - there was never a cycle
            //If the list does not have a cycle, fastRunner will reach the end.
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next; // iterate once
            fast = fast.next.next; // iterate two at a time
        }

        return true;


    }
    // reverse a linkedList
    static Node reverseLinkedList(Node head) {
      // make nodes
        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            // this is where the pointer is reversing to the previous node
            current.next = previous;
            // traversing down the list now
            previous = current;
            current = previous;
        }

        return previous;
    }

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
