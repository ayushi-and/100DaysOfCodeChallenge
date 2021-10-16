package Day84;

import java.util.LinkedList;
import java.util.Queue;

//Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
/*
Examples:
Input :
                 1
               /   \
              2     3
             / \     \
            4   5     6
Output : 1 2 4
Input :
        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Output :1 2 4 5 6
 */
//we will do a level order traversal on the tree and print the leftmost node at every level.
// Time Complexity: O(n), where n is the number of nodes in the binary tree.
public class LeftViewOfBinaryTreeUsingQueue {
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int d) {
            data = d;
            left = null;
            right = null;
        }

        static void leftView(Node root) {
            if(root == null) {
                return;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()) {

                int n = queue.size();
                for(int i = 1; i <= n; i++) {
                    Node temp = queue.poll();

                    if(i == 1) {
                        System.out.print(temp.data + " ");
                    }

                    if(temp.left != null) {
                        queue.add(temp.left);
                    }
                    if(temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }
        }
        
        public static void main(String[] args) {
            Node root = new Node(12);
            root.left = new Node(10);
            root.right = new Node(30);
            root.right.left = new Node(25);
            root.right.right = new Node(40);

            leftView(root);
        }
    }
}
