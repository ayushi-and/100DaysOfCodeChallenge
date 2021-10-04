package Day71;

//Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
//The boundary includes left boundary, leaves, and right boundary in order without duplicate nodes. (The values of the nodes may still be duplicates.)
//Time Complexity: O(n) where n is the number of nodes in binary tree.
public class BoundaryTraversalOfBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    static void printBoundary(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");

        // Print the left boundary in top-down manner.
        printLeftBoundary(root.left);

        //print all leaf nodes
        printLeaves(root.left);
        printLeaves(root.right);

        // Print the right boundary in bottom-up manner
        printRightBoundary(root.right);
    }

    static void printLeaves(Node node) {
        if (node == null) {
            return;
        }
        printLeaves(node.left);
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }

    //A function to print all left boundary nodes, except a leaf node.
    static void printLeftBoundary(Node node) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            System.out.print(node.data + " ");
            printLeftBoundary(node.left);
        }

        else if(node.right != null) {
            System.out.print(node.data + " ");
            printLeftBoundary(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    //A function to print all right boundary nodes, except a leaf node.
    static void printRightBoundary(Node node) {
        if(node == null) {
            return;
        }
        if(node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printRightBoundary(node.right);
            System.out.print(node.data + " ");
        }

        else if(node.left != null) {
            printRightBoundary(node.left);
            System.out.print(node.data + " ");
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        printBoundary(root);
    }
}
