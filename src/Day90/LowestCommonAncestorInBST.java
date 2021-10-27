package Day90;

//Lowest Common Ancestor in Binary Search Tree
//TC: O(h): h is height of BST i.e O(log n)
public class LowestCommonAncestorInBST {

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

    //recursive solution
    //Space Complexity: O(h).
    //If recursive stack space is ignored, the space complexity of the above solution is constant.
    static Node findLCAInBST(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }
        if(root.data > n1 && root.data > n2) {
            return findLCAInBST(root.left, n1, n2);
        }
        if(root.data < n1 && root.data < n2) {
            return findLCAInBST(root.right, n1, n2);
        }
        return root;
    }

    //Time Complexity: O(h).
    //The Time Complexity of the above solution is O(h), where h is the height of the tree.
    //Space Complexity: O(1).
    //The space complexity of the above solution is constant.
    static void findLCAInBSTOptimized(Node root, int n1, int n2) {
        if(root == null) {
            return;
        }
        while(root != null) {
            if(root.data == n1 || root.data == n2) {
                System.out.print(root.data);
                return;
            }
            if(n1 > root.data && n2 > root.data) {
                root = root.right;
            }
            else if(n1 < root.data && n2 < root.data) {
                root = root.left;
            }
            else break;
        }
        System.out.println("LCA is " + root.data);
    }
    
    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(-10);
        root.right = new Node(30);
        root.left.right = new Node(8);
        root.right.left = new Node(25);
        root.right.right = new Node(60);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(9);
        root.right.left.right = new Node(28);
        root.right.right.right = new Node(78);

        Node node = findLCAInBST(root, 28, 78);
        System.out.println("LCA is " + node.data);

        node = findLCAInBST(root, 30, 78);
        System.out.println("LCA is " + node.data);

        findLCAInBSTOptimized(root, 6, 9);

    }
}
