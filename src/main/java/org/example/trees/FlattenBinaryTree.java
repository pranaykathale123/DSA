package org.example.trees;

public class FlattenBinaryTree {

    private static TreeNode prev = null;
    public static void flatten(TreeNode root) {

        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    // Helper function to print flattened linked list
    public static void printFlattened(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
        System.out.println("null");
    }

    // MAIN METHOD INSIDE SAME CLASS
    public static void main(String[] args) {

        /* Creating sample binary tree:

                 1
               /   \
              2     5
             / \     \
            3   4     6

        Expected Flattened Output:
        1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.println("Flattening Binary Tree...");
        flatten(root);

        System.out.println("Flattened Linked List:");
        printFlattened(root);
    }
}
