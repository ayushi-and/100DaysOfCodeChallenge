package Day93;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Print level order traversal of binary tree in reverse order(bottom to up)
public class ReverseLevelOrderTraversalBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    //using recursion
    //O(n^2)
    static void levelOrderTraversalInReverse(Node root) {
        int h = getHeight(root);

        for(int i = h; i >= 1; i--) {
            printNodesAtGivenLevel(root, i);
        }
    }

    static void printNodesAtGivenLevel(Node root, int level) {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.print(" " + root.data);
        }
        else if(level > 1) {
            printNodesAtGivenLevel(root.left, level - 1);
            printNodesAtGivenLevel(root.right, level - 1);
        }
    }

    static int getHeight(Node root) {
        if(root == null) {
            return 0;
        }
        else {
            int lh = getHeight(root.left);
            int rh = getHeight(root.right);

            return Math.max(lh, rh) + 1;
        }
    }

    //Iterative approach : using stack and queue
    //O(n)
    static void levelOrderTraversalInReverseOptimized(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Do something like normal level order traversal order.Following are the differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        while(!queue.isEmpty()) {
            root = queue.peek();
            queue.remove();
            stack.push(root);

            if(root.right != null) {
                queue.add(root.right);
            }
            if(root.left != null) {
                queue.add(root.left);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(" " + stack.pop().data);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.right.left = new Node(10);

        System.out.println("Printing using recursion");
        levelOrderTraversalInReverse(root);

        System.out.println("\nPrinting using iterative approach");
        levelOrderTraversalInReverseOptimized(root);

    }
}
