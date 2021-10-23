package Day88;

//Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to find the least common ancestor.
//Let T be a rooted  The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2
//as descendants (where we allow a node to be a descendant of itself).
//The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root.
//Computation of lowest common ancestors may be useful, for instance, as part of a procedure for determining the distance between pairs of nodes in a tree:
//the distance from n1 to n2 can be computed as the distance from the root to n1, plus the distance from the root to n2,
//minus twice the distance from the root to their lowest common ancestor.

import java.util.ArrayList;
import java.util.List;

//TC: O(n); The tree is traversed twice, and then path arrays are compared.
public class LowestCommonAncestorBinaryTree {

    static private List<Integer> path1 = new ArrayList<>();
    static private List<Integer> path2 = new ArrayList<>();

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

    static int findLCA(Node root, int n1, int n2) {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    static int findLCAInternal(Node root, int n1, int n2) {
        if(!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }

        int i;
        for(i = 0; i < path1.size() && i < path2.size(); i++) {
            if(!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }
        return path1.get(i - 1);
    }

    //Find the path from root node to given node of the tree, Stores the
    //path in a list path, returns true if path exists otherwise false
    static boolean findPath(Node root, int n, List<Integer> path) {
        if(root == null) {
            return false;
        }

        // Store this node. The node will be removed if not in path from root to n.
        path.add(root.data);

        if(root.data == n) {
            return true;
        }
        if(root.left != null && findPath(root.left, n, path)) {
            return true;
        }
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
        // If not present in subtree rooted with root, remove root from path and return false
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + findLCA(root, 4,5));
        System.out.println("LCA(4, 6): " + findLCA(root, 4,6));
        System.out.println("LCA(3, 4): " + findLCA(root, 3,4));
        System.out.println("LCA(2, 4): " + findLCA(root, 2,4));
    }

}
