package Day87;

import java.util.LinkedList;
import java.util.Queue;

//Print every level in new line
public class LevelOrderTraversalLevelByLevel {
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
    static void levelByLevelTraversal(Node root) {
        if(root == null) {
            return;
        }
        int h = getHeight(root);
        for(int i = 1; i <= h; i++) {
            printNodesAtGivenLevel(root, i);
            System.out.println(); //print a new line after every call to printGivenLevel() i.e. after every level
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


    //Iterative approach - using queue
    //O(n)
    static void levelByLevelTraversalOptimized(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int n = queue.size();
            while(n > 0) {
                Node node = queue.peek();
                System.out.print(node.data + " ");
                queue.remove();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                n--;
            }
            System.out.println();
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
        levelByLevelTraversal(root);

        System.out.println("Printing using iterative approach");
        levelByLevelTraversalOptimized(root);

    }
}
