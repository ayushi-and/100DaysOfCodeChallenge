package Day74;

//Search a given key in BST
//O(n) in BST in worst case: for skewed tree
//For balanced binary search tree: O(logn)
public class BSTSearching {
    static class Node {
        int key;
        Node left;
        Node right;

        Node(int d) {
            key = d;
            left = right = null;
        }
    }

    static Node search(Node root, int key) {
        if(root == null || root.key == key) {
            return root;
        }
        if(key < root.key) {
            return search(root.left, key);
        }
        return search(root.right, key);

    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);

        Node result = search(root, 70);
        System.out.println(result.key);
    }
}
