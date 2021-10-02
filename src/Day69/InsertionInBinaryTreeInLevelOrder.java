package Day69;

//Given a binary tree and a key, insert the key into the binary tree at the first position available in level order.

import java.util.LinkedList;
import java.util.Queue;

//Approach: The idea is to do iterative level order traversal of the given tree using queue. If we find a node whose left child is empty,
//we make new key as left child of the node. Else if we find a node whose right child is empty, we make the new key as right child.
//We keep traversing the tree until we find a node whose either left or right child is empty.
public class InsertionInBinaryTreeInLevelOrder {
    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    static void inorder(Node root) {
        Node current = root;
        if(current == null) {
            return;
        }

        inorder(current.left);
        System.out.print(current.key + " ");
        inorder(current.right);
    }

    static void insert(Node root, int key) {
        Node current = root;
        if(current == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(current);

        while(!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();

            if(temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else {
                queue.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else {
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        inorder(root);
        insert(root, 12);
        System.out.println();
        inorder(root);
    }

}
