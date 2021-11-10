package Day100;

import java.util.ArrayList;
import java.util.List;

//---Unique Binary Search Trees II
//Doubt on printing null values.
//Given an integer n, return all the structurally unique BST's (binary search trees),
//which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
//Example 1:
//Input: n = 3
//Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
//Example 2:
//Input: n = 1
//Constraints:
//1 <= n <= 8

public class UniqueBinarySearchTrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public static List<TreeNode> generateTrees(int n) {
        return generateTree(1, n);
    }
    public static List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start > end) {
            result.add(null);
            return result;
        }

        if(start == end) {
            result.add(new TreeNode(start));
            return result;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> leftNode = generateTree(start, i - 1);
            List<TreeNode> rightNode = generateTree(i + 1, end);

            for(int j = 0; j < leftNode.size(); j++) {
                TreeNode left = leftNode.get(j);
                for (int k = 0; k < rightNode.size(); k++)
                {
                    TreeNode right = rightNode.get(k);
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }
    static void levelOrderTraversal(TreeNode root)
    {
        if(root == null) {
            return;
        }
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }

    static int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        else {
            int lHeight = height(root.left);
            int rHeight = height(root.right);

            if(lHeight > rHeight) {
                return (lHeight + 1);
            }
            else return (rHeight + 1);
        }
    }

    static void printCurrentLevel(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.print(root.val + " ");
        }
        else if (level > 1) {
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }

    public static void main(String[] args) {
        List<TreeNode> totalTrees = generateTrees(3);
        for(int i = 0; i < totalTrees.size(); i++) {
            levelOrderTraversal(totalTrees.get(i));
            System.out.println();
        }
    }
}
