package Day85;

//Level order traversal of a tree is breadth first traversal for the 
//Method 1 - Use function to print a current level.
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
public class LevelOrderTraversalBFS {
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
        int h = getHeight(root); //height of binary tree; number of levels

        for(int i = 1; i <= h; i++) {
            printCurrentLevelNodes(root, i); //print nodes at each level
        }
    }

    static void printCurrentLevelNodes(Node root, int level) {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.print(root.data + " ");
        }
        else if(level > 1) {
            printCurrentLevelNodes(root.left, level - 1);
            printCurrentLevelNodes(root.right, level - 1);
        }
    }

    //Method to get the height of Binary tree
    static int getHeight(Node root) {
        if(root == null) {
            return 0;
        }
        else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            if(leftHeight > rightHeight) {
                return leftHeight + 1;
            }
            else {
                return rightHeight + 1;
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
