package Leetcode.Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    // Use this template to solve BFS problems
    //Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
    static List<List<Integer>> levelOrder(TreeNode root) {
        // return list
        List<List<Integer>> returnList = new ArrayList<>();
        if (root == null) {
            return returnList;
        }

        // for breadth first search
        Queue<TreeNode> queue = new LinkedList<>();
        // add root to queue
        queue.add(root);
        // processing the BFS
        while(!queue.isEmpty()) {
            // get the size of the queue
            // this is the number of nodes in the current level we have tos process
            int size = queue.size();
            // on every single level of the tree record the values
            List<Integer> currentLevel = new ArrayList<>();
            // iterate all the things in the queueu
            for (int i = 0; i < size; i++) {
                // get the current node we need to process
                TreeNode current = queue.remove();
                currentLevel.add(current.val);
                // next process the childeren but checking if it has left or right child
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            returnList.add(currentLevel);
        }
        return returnList;
    }

    //Given a binary tree, find its maximum depth.
    // Use recursion
    //The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    public int maxDepth(TreeNode root) {
        // is the base case
        if (root == null) {
            return 0;
        }

        // asking the next right and left node "what level are you at?"
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int max = Math.max(left, right);

        return max + 1;
    }
}
