package Day94;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find if there is a path from root to leaf
 * which sums to this sum.
 *
 * Solution
 * Keep going left and right and keep subtracting node value from sum.
 * If leaf node is reached check if whatever sum is remaining same as leaf node data.
 *
 * Time complexity is O(n) since all nodes are visited.
 *
 * Test cases:
 * Negative number, 0 and positive number
 * Tree with 0, 1 or more nodes
 */
public class RootToLeafSumBinaryTree {
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
        if(key <= prev.key) {
            prev.left = new Node(key);
        }
        else {
            prev.right = new Node(key);
        }
        return root;
    }

    static boolean printPath(Node root, int sum, List<Integer> result) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) { //leaf node
            if(root.key == sum) {
                result.add(root.key);
                return true;
            }
            else {
                return false;
            }
        }

        if(printPath(root.left, sum - root.key, result)) {
            result.add(root.key);
            return true;
        }
        if(printPath(root.right, sum - root.key, result)) {
            result.add(root.key);
            return true;
        }

        return false;

    }

    public static void main(String[] ar) {
        RootToLeafSumBinaryTree tree = new RootToLeafSumBinaryTree();

        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(7);
        tree.insert(19);
        tree.insert(20);
        tree.insert(4);
        tree.insert(3);

        List<Integer> list = new ArrayList<>();

        boolean isPathExist = printPath(tree.root, 22, list);

        if(isPathExist) {
            list.forEach(key -> System.out.print(key + " "));
        }
        else {
            System.out.println("No path for sum " + 22);
        }

    }
}
