package Day73;

//Insertion in Binary Search tree using iterative method
//TC: O(n) in worst case (because of skewed tree)
//TC: O(log n) for balanced BST
public class BSTInsertionIterative {
    Node root;

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int d) {
            key = d;
            left = right = null;
        }
    }

    Node insert(int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        }
        Node current = root;
        Node prev = null;
        while(current != null) {
            prev = current;
            if(key < current.key) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        if(key < prev.key) {
            prev.left = new Node(key);
        }
        else {
            prev.right = new Node(key);
        }
        return root;
    }

    static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        BSTInsertionIterative tree = new BSTInsertionIterative();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inorder(tree.root);
    }
}
