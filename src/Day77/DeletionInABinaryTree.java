package Day77;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom 
(i.e. the deleted node is replaced by the bottom-most and rightmost node). This is different from BST deletion. 
Here we do not have any order among elements, so we replace with the last element.

Examples :
Delete 10 in below tree
       10
     /    \         
    20     30
Output :    
       30
     /             
    20     


Delete 20 in below tree
       10
     /    \         
    20     30
            \
            40
Output :    
       10
     /   \             
    40    30   
 */
public class DeletionInABinaryTree {
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

    static void delete(Node root, int key) {
        Node current = root;

        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            if(root.key == key) {
                root = null;
                return;
            }
        }

        Node keyNode = null;
        Node lastNode = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(current);

        while(!queue.isEmpty()) {
            lastNode = queue.peek();
            queue.remove();

            if(lastNode.key == key) {
                keyNode = lastNode;
            }
            if(lastNode.left != null) {
                queue.add(lastNode.left);
            }
            if(lastNode.right != null) {
                queue.add(lastNode.right);
            }
        }
        if(keyNode != null) {
            keyNode.key = lastNode.key;
            //Remove the last node (write a separate function in which we have to traverse again since we can't do the lastNode's key to null directly,
            // we have to keep the pointer of its prev node to make the next of it as null, so traverse again)
            removeLastNode(root, lastNode);
        }
    }

    private static void removeLastNode(Node root, Node lastNode) {
        if(root == null) {
            return;
        }
        if(root == lastNode) {
            root = null;
            return;
        }
        if(root.left == lastNode) {
            root.left = null;
        }
        if(root.right == lastNode) {
            root.right = null;
        }
        removeLastNode(root.left, lastNode);
        removeLastNode(root.right, lastNode);
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

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        inorder(root);
        delete(root, 11);
        System.out.println();
        inorder(root);
    }
}
