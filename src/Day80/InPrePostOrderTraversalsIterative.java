package Day80;

import java.util.Stack;

//Iterative postorder traversal of binary tree
//TC:O(n)
public class InPrePostOrderTraversalsIterative {

    static Stack<Node> stack1 = new Stack<>();
    static Stack<Node> stack2 = new Stack<>();

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    //left->right->root
    //Stack- LIFO
    //using two stacks
    static void postorder(Node root) {
        if(root == null) {
            return;
        }

        stack1.push(root);

        while(!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);

            if(root.left != null) {
                stack1.push(root.left);
            }

            if(root.right != null) {
                stack1.push(root.right);
            }
        }

        while(!stack2.isEmpty()) {
            System.out.print(" " + stack2.pop().data);
        }
    }


    //left->right->root
    //Stack- LIFO
    //using single stack
    static void postorderWithOneStack(Node root) {
        Node current = root;
        while(current != null || !stack1.isEmpty()) {
            if(current != null) {
                stack1.push(current);
                current = current.left;
            }
            else {
                Node temp = stack1.peek().right;
                if(temp == null) { //i.e that is a leaf node, it's right child is also empty so we can visit that
                    temp = stack1.pop();
                    System.out.print(" " + temp.data);

                    while(!stack1.isEmpty() && temp == stack1.peek().right) {
                        temp = stack1.pop();
                        System.out.print(" " + temp.data);
                    }
                }
                else {
                    current = temp;
                }
            }

        }
    }

    //root->left->right
    //Stack- LIFO
    //using single stack
    static void preorder(Node root) {
        if(root == null) {
            return;
        }

        stack1.push(root);

        while(!stack1.isEmpty()) {
            root = stack1.pop();
            System.out.print(" " + root.data);

            if (root.right != null) {
                stack1.push(root.right);
            }
            if (root.left != null) {
                stack1.push(root.left);
            }
        }
    }

    //left->root->right
    //Stack: LIFO
    //using single stack
    static void inorder(Node root) {
        if(root == null) {
            return;
        }
        while(true) {
            if(root != null) {
                stack1.push(root);
                root = root.left;
            }
            else {
                //root has to be null and stack has to be empty to break out of this while loop
                if(stack1.isEmpty()) {
                    break;
                }
                root = stack1.pop();
                System.out.print(" " + root.data);
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-1);
        root.right = new Node(11);
        root.left.left = new Node(-2);
        root.left.right = new Node(-3);
        root.right.left = new Node(21);
        root.right.right = new Node(6);
        root.left.right.right = new Node(5);

        System.out.println("Postorder traversal is");
        postorder(root);

        System.out.println("\nPostorder traversal using single stack is");
        postorderWithOneStack(root);

        System.out.println("\nPreorder traversal is");
        preorder(root);

        System.out.println("\nInorder traversal is");
        inorder(root);
    }
}
