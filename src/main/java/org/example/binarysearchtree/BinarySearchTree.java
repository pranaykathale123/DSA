package org.example.binarysearchtree;

import java.util.Scanner;

public class BinarySearchTree {

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode curr = root;
        while (true) {
            if (curr.val < val) {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }


    public static TreeNode createBST() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        TreeNode root = null;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int val = sc.nextInt();
            root = insertIntoBST(root, val);
        }

        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            return helper(root);
        }

        TreeNode dummy = root;

        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    private static TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            TreeNode lastRightChild = findLastRightChild(root.left);
            lastRightChild.right = rightChild;
            return root.left;
        }
    }

    private static TreeNode findLastRightChild(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }


    public static void printBST(TreeNode root) {
        if (root == null) return;
        printBST(root.left);
        System.out.print(root.val + " ");
        printBST(root.right);
    }


    public static void main(String[] args) {

        // Create BST using user input
        TreeNode root = createBST();

        System.out.print("\nBST (Inorder Traversal): ");
        printBST(root);

        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nEnter value to delete: ");
        int key = sc.nextInt();

        root = deleteNode(root, key);

        System.out.print("BST after deletion: ");
        printBST(root);
    }
}
