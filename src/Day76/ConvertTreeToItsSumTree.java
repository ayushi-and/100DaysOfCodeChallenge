package Day76;

/*
Given a Binary Tree where each node has positive and negative values. Convert this to a tree where each node contains the sum of the left and right sub trees in the original  The values of leaf nodes are changed to 0.

For example, the following tree

                  10
               /      \
             -2        6
           /   \      /  \
         8     -4    7    5
should be changed to

                 20(4-2+12+6)
               /      \
         4(8-4)      12(7+5)
           /   \      /  \
         0      0    0    0
 */
//Time Complexity: The solution involves a simple traversal of the given 
//So the time complexity is O(n) where n is the number of nodes in the given Binary 
public class ConvertTreeToItsSumTree {
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static int toSumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int oldValue = root.data;

        root.data = toSumTree(root.left) + toSumTree(root.right);

        return root.data + oldValue;
    }

    static void printInorder(Node root) {
        if(root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }


    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        toSumTree(root);
        System.out.println("Inorder Traversal of the resultant tree is:");
        printInorder(root);
    }
}
