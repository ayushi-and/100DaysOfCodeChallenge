package Day96;

/* Symmetric Tree (Mirror Image of itself)
Given a binary tree, check whether it is a mirror of itself.
For example, this binary tree is symmetric:

     1
   /   \
  2     2
 / \   / \
3   4 4   3

But the following is not:
    1
   / \
  2   2
   \   \
   3    3
 */
//Time Complexity: O(N)
//Auxiliary Space: O(h) where h is the maximum height of the tree
public class SymmetricTree {
    static class Node {
        int key;
        Node left, right;

        Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    static boolean isSymmetric(Node root) {
        return isMirrorImage(root, root);
    }

    static boolean isMirrorImage(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 != null && root2 != null && root1.key == root2.key) {
            return (isMirrorImage(root1.left, root2.right) && isMirrorImage(root1.right, root2.left));
        }
        return false;
    }

    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        boolean output = isSymmetric(root);
        if (output == true)
            System.out.println("Symmetric");
        else
            System.out.println("Not symmetric");
    }
}
