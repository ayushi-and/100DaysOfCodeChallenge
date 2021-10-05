package Day72;

//Insertion in Binary Search tree using Recursion
//TC: O(n) in worst case (because of skewed tree)
//TC: O(log n) for balanced BST
public class BSTInsertion {
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

    void insert(int key) {
        root = insertRecord(root, key);
    }

    Node insertRecord(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        }

        if(key < root.key) {
            root.left = insertRecord(root.left, key);
        }
        if(key > root.key) {
            root.right = insertRecord(root.right, key);
        }
        return root;
    }

    void inorder() {
        inorderRecord(root);
    }

    void inorderRecord(Node root) {

        if(root != null) {
            inorderRecord(root.left);
            System.out.print(root.key + " ");
            inorderRecord(root.right);
        }
    }

    public static void main(String[] args) {

        BSTInsertion tree = new BSTInsertion();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inorder();
    }
}
