package Day82;

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
//Using Recursion
//Time Complexity: The function does a simple traversal of the tree, so the complexity is O(n).
//Auxiliary Space: O(n), due to the stack space during recursive call.
public class LeftViewOfBinaryTree {
    static int maxLevel = 0;
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static void leftView(Node root) {
        printLeftView(root, 1);
    }

    static void printLeftView(Node root, int level) {
        if(root == null) {
            return;
        }
        if(maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }

        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
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
