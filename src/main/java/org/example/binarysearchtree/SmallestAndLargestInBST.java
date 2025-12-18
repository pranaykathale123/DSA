package org.example.binarysearchtree;

public class SmallestAndLargestInBST {

    public static int findSmallest(TreeNode root) {

        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public static int findLargest(TreeNode root) {

        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
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

        int smallest = findSmallest(root);
        int largest = findLargest(root);

        System.out.println("Smallest in BST: " + smallest);
        System.out.println("Largest in BST: " + largest);
    }
}
