package Day79;

//Tree Traversals (Inorder, Preorder and Postorder)
/*
Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
Breadth First or Level Order Traversal : 1 2 3 4 5
 */
public class DFSTraversalsInPrePostBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static void printPreorder(Node root) { //Rlr
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    static void printInorder(Node root) { //lRr
        if(root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    static void printPostorder(Node root) { //lrR
        if(root == null) {
            return;
        }

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left= new Node(2);
        root.right= new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        printPreorder(root);

        System.out.println("\nInorder traversal of binary tree is ");
        printInorder(root);

        System.out.println("\nPostorder traversal of binary tree is ");
        printPostorder(root);
    }

}
