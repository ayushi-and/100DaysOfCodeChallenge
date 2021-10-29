package Day92;

//Given a binary tree, the task is to print all the leaf nodes of the binary tree from either right to left or left to right.
public class PrintLeafNodes {
    static class Node {
        int data;
        Node left, right;
        
        Node(int d) {
            data = d;
        }
    }


    static void printLeafNodes(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print( root.data +" ");
            return;
        }
        if (root.left != null) { //print from left to right, if want from right to left, write right first and then left.
            printLeafNodes(root.left);
        }
        if (root.right != null) {
            printLeafNodes(root.right);
        }
    }

    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.right.right.left = new Node(9);
        root.left.left.left.right = new Node(10);

        printLeafNodes(root);
    }
}
