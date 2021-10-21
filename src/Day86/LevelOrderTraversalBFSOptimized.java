package Day86;

import java.util.LinkedList;
import java.util.Queue;

//Level order traversal of a tree is breadth first traversal for the
//Method 2 - Using Queue
/*
There are basically two functions in this method. One is to print all nodes at a given level (printCurrentLevel),
and other is to print level order traversal of the tree (printLevelOrder).
printLevelOrder makes use of printCurrentLevel to print nodes at all levels one by one starting from the root.
 */
/*
Time Complexity: O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in the skewed tree.
So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2), where n is the number of nodes in the binary tree.
Space Complexity: O(n) in worst case. For a skewed tree, printGivenLevel() uses O(n) space for call stack.
For a Balanced tree, the call stack uses O(log n) space, (i.e., the height of the balanced tree).
 */
//Time Complexity: O(n) where n is the number of nodes in the binary tree
//Space Complexity: O(n) where n is the number of nodes in the binary tree
public class LevelOrderTraversalBFSOptimized {
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

    static void printLevelOrder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left= new Node(2);
        root.right= new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);

        System.out.println("Level order traversal of binary tree is ");

        printLevelOrder(root);
    }
}
