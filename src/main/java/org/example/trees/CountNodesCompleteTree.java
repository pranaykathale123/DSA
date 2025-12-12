package org.example.trees;

public class CountNodesCompleteTree {

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = leftHeight(root);
        int right = rightHeight(root);

        // If it is a perfect binary tree
        if (left == right) {
            return (1 << (left + 1)) - 1;  // same as (2^(h+1))-1
        }

        // Otherwise compute normally
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int leftHeight(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private static int rightHeight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        /*
             Example Complete Binary Tree:

                        1
                      /   \
                     2     3
                    / \   /
                   4   5 6

             Node count = 6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);


        int total = countNodes(root);

        System.out.println("Total nodes in the complete tree = " + total);
    }
}
