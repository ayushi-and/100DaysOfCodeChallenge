package Day89;

//Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to find the least common ancestor.
//Let T be a rooted  The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2
//as descendants (where we allow a node to be a descendant of itself).
//The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root.
//Computation of lowest common ancestors may be useful, for instance, as part of a procedure for determining the distance between pairs of nodes in a tree:
//the distance from n1 to n2 can be computed as the distance from the root to n1, plus the distance from the root to n2,
//minus twice the distance from the root to their lowest common ancestor.

//Method 2 (Using Single Traversal)

/*
Method 1 finds LCA in O(n) time but requires three tree traversals plus extra spaces for path arrays. If we assume that the keys n1 and n2 are present
in Binary Tree, we can find LCA using a single traversal of Binary Tree and without extra storage for path arrays.
The idea is to traverse the tree starting from the root. If any of the given keys (n1 and n2) matches with the root,
then the root is LCA (assuming that both keys are present). If the root doesn’t match with any of the keys, we recur for the left and right subtree.
The node which has one key present in its left subtree and the other key present in the right subtree is the LCA.
If both keys lie in the left subtree, then the left subtree has LCA also, otherwise, LCA lies in the right subtree.
 */
//TC:  O(n) as the method does a simple tree traversal in a bottom-up fashion; single traversal
public class LowestCommonAncestorBinTreeSingleTraversal {

    static boolean isVisited1 = false;
    static boolean isVisited2 = false;

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

    static Node findLCA(Node root, int n1, int n2) {
        isVisited1 = false;
        isVisited2 = false;

        Node lca =  findLCAInternal(root, n1, n2);
        if (isVisited1 && isVisited2) {
            return lca;
        }
        else {
            return null;
        }
    }

    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    static Node findLCAInternal(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        Node temp = null;
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        /*if(root.data == n1 || root.data == n2) {
            return root;
        }*/

        if(root.data == n1) {
            isVisited1 = true;
            temp = root;
        }

        if(root.data == n2) {
            isVisited2 = true;
            temp = root;
        }

        // Look for keys in left and right subtrees
        Node leftLCA = findLCAInternal(root.left, n1, n2);
        Node rightLCA = findLCAInternal(root.right, n1, n2);

        if(temp != null) {
            return temp;
        }


        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (leftLCA != null && rightLCA != null) { //getting non null value from both left and right child
            return root;
        }

        if(leftLCA == null && rightLCA == null) {
            return null;
        }

        // Otherwise check if left subtree or right subtree is LCA
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node lca = findLCA(root, 4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");

        lca = findLCA(root, 4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.data);
        else
            System.out.println("Keys are not present");
    }
}
