package InterviewCake.StacksQueues.LargestElementInStack;

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(4);
        maxStack.push(1);
        maxStack.push(3);
        maxStack.push(7);
        maxStack.pop();

        System.out.println(maxStack);

    }

    //You want to be able to access the largest element in a stack. ↴
    //Use the built-in Stack class to implement a new class MaxStack with a method getMax() that returns the largest element in the stack. getMax() should not remove the item.
    static class MaxStack {
        // the main stack
        private Deque<Integer> stack = new ArrayDeque<>();
        // the stack to track the max
        private Deque<Integer> maxesStack = new ArrayDeque<>();

        // Add a new item to the top of our stack. If the item is greater
        // than or equal to the last item in maxesStack, it's
        // the new max! So we'll add it to maxesStack.
        public void push(int item) {
            stack.push(item);
            if (maxesStack.isEmpty() || item >= maxesStack.peek()) {
                maxesStack.push(item);
            }
        }

        // Remove and return the top item from our stack. If it equals
        // the top item in maxesStack, they must have been pushed in together.
        // So we'll pop it out of maxesStack too.
        public int pop() {
            int item = stack.pop();
            if (item == maxesStack.peek()) {
                maxesStack.pop();
            }
            return item;
        }

        // The last item in maxesStack is the max item in our stack.
        public int getMax() {
            return maxesStack.peek();
        }
    }
}


