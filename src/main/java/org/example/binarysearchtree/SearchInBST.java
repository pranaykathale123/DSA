package org.example.binarysearchtree;

public class SearchInBST {
    public static TreeNode searchBST(TreeNode root, int val) {

        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
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

        int valToSearch = 11;

        TreeNode resultNode = searchBST(root, valToSearch);
        if (resultNode != null) {
            System.out.println("Node with value " + valToSearch + " found: " + resultNode.val);
        } else {
            System.out.println("Node with value " + valToSearch + " not found in the BST.");
        }
    }
}
