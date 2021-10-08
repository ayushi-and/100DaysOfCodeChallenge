package Day75;

import java.util.Stack;

//Check if Binary Tree is Binary Search Tree
/*
 * Given a binary tree, return true if it is binary search tree else return false.
 *
 * Solution
 * Keep min, max for every recursion. Initial min and max is very small and very larger
 * number. Check if root.data is in this range. When you go left pass min and root.data and
 * for right pass root.data and max.
 *
 * Time complexity is O(n) since we are looking at all nodes.
 * Auxiliary Space: O(1) if Function Call Stack size is not considered, otherwise O(n)
 * Test cases:
 * Null tree
 * 1 or 2 nodes tree
 * Binary tree which is actually BST
 * Binary tree which is not a BST
 */
public class CheckIsBinaryTreeABST {

    static int min = Integer.MIN_VALUE;
    static int max = Integer.MAX_VALUE;

    static class Node {
        int key;
        Node left, right;

        Node(int d) {
            key = d;
            left = right = null;
        }
    }

    //Using Recursion
    static boolean isBST(Node root, int min, int max) {

        if(root == null) {
            return true;
        }
        if(root.key <= min || root.key > max) {
            return false;
        }
        return isBST(root.left, min, root.key - 1) && isBST(root.right, root.key + 1, max);
    }

    //Using Iterative method
    //Time Complexity: O(N), where N is count of nodes in the binary tree
    //Auxiliary Space: O(N)
    static boolean isBSTIterative(Node root) {
        // Stores root node and left
        // subtree of each node
        Stack<Node > Stack = new Stack<>();

        // Stores previous visited node
        Node prev = null;

        // Traverse the binary tree
        while (!Stack.isEmpty() ||
                root != null) {

            // Traverse left subtree
            while (root != null) {

                // Insert root into Stack
                Stack.add(root);

                // Update root
                root = root.left;
            }

            // Stores top element of Stack
            root = Stack.peek();

            // Remove the top element of Stack
            Stack.pop();

            // If data value of root node less
            // than data value of left subtree
            if(prev != null &&
                    root.key <= prev.key) {
                return false;
            }

            // Update prev
            prev = root;

            // Traverse right subtree
            // of the tree
            root = root.right;
        }
        return true;
    }

    public static void main(String[] ar) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(19);
        root.left.left = new Node(-5);
        root.right.left = new Node(17);
        root.right.right = new Node(21);

        //boolean bst = isBST(root, min, max);
        boolean bst = isBSTIterative(root);

        if(bst) {
            System.out.println("BST");
        }
        else {
            System.out.println("Not a BST");
        }

    }
}
