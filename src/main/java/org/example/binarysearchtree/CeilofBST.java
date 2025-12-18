package org.example.binarysearchtree;

public class CeilofBST {

    public static int ceilInBST(TreeNode root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.val == key) {
                return root.val;
            } else if (root.val < key) {
                root = root.right;
            } else {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {

        /*
                BST Structure:
                     8
                   /   \
                  4     12
                 / \    / \
                2   6  10  14
        */

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        int key = 5;

        int ceil = ceilInBST(root, key);
        System.out.println("Ceil of " + key + " is: " + ceil);
    }
}
