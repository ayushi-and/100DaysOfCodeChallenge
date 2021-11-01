package Day95;

//Given the root of binary tree, find the total number of nodes in this binary tree
public class SizeOfBinaryTree {
    static class Node {
        int key;
        Node left;
        Node right;

        Node(int d) {
            key = d;
            left = right = null;
        }
    }

    static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int countLeft = countNodes(root.left);
        int countRight = countNodes(root.right);

        return countLeft + countRight + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);

        System.out.println(countNodes(root));
    }
}
