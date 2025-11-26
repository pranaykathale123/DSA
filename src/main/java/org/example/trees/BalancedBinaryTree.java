package org.example.trees;

public class BalancedBinaryTree {
    // Method to check if tree is balanced
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // Return height, OR -1 if unbalanced
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        if (left == -1) {
            return -1;        // left subtree unbalanced
        }

        int right = height(root.right);
        if (right == -1) {
            return -1;        // right subtree unbalanced
        }

        if (Math.abs(left - right) > 1) {
            return -1;        // current node unbalanced
        }

        return 1 + Math.max(left, right); // return height
    }

    // Main method to test
    public static void main(String[] args) {

        BalancedBinaryTree sol = new BalancedBinaryTree();

        /*
               3
             /   \
            9     20
                 /  \
                15   7
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        boolean result = sol.isBalanced(root);
        System.out.println("Is the tree balanced? " + result);
    }
}
