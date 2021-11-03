package Day97;

import java.util.Stack;

//Level Order Traversal In Spiral form
//First level should print from left to right, second level should print from right to left and so on.
public class TreeTraversalSpiralOrder {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    //recursive approach
    //O(n^2)
    static void spiralOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        int h = getHeight(root);
        boolean flag = false; //flag is false means left to right, if true then right to left
        for(int i = 1; i <= h; i++) {
            printNodesAtGivenLevel(root, i, flag);
            flag = !flag;
        }
    }

    static void printNodesAtGivenLevel(Node root, int level, boolean flag) {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.print(" " + root.data);
        }
        else if(level > 1) {
            if(flag == false) {
                printNodesAtGivenLevel(root.left, level - 1, flag);
                printNodesAtGivenLevel(root.right, level - 1, flag);
            }
            else {
                printNodesAtGivenLevel(root.right, level - 1, flag);
                printNodesAtGivenLevel(root.left, level - 1, flag);
            }
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

    //Iterative approach
    //O(n)
    //using two stacks
    static void spiralOrderTraversalOptimized(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while(!stack1.empty() || !stack2.empty()) {
            while(!stack1.empty()) {
                Node temp = stack1.pop();
                System.out.print(" " + temp.data);

                if(temp.left != null) {
                    stack2.push(temp.left);
                }
                if(temp.right != null) {
                    stack2.push(temp.right);
                }
            }

            while(!stack2.empty()) {
                Node temp = stack2.pop();
                System.out.print(" " + temp.data);

                if(temp.right != null) {
                    stack1.push(temp.right);
                }
                if(temp.left != null) {
                    stack1.push(temp.left);
                }
            }
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
        spiralOrderTraversal(root);

        System.out.println("\nPrinting using iterative approach");
        spiralOrderTraversalOptimized(root);

    }
}
