package org.example.trees;

public class SameTree {
    // Method to check if two trees are the same
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // If both nodes are null → trees match at this point
        if (p == null && q == null) {
            return true;
        }

        // If one is null and the other is not → mismatch
        if (p == null || q == null) {
            return false;
        }

        // If values differ → not the same tree
        if (p.val != q.val) {
            return false;
        }

        // Recursively check left and right
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    // Main method for testing
    public static void main(String[] args) {

        SameTree sol = new SameTree();

        /*
               Tree 1           Tree 2
                 1                1
                / \              / \
               2   3            2   3
        */

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean result = sol.isSameTree(p, q);
        System.out.println("Are the two trees identical? " + result);
    }
}
