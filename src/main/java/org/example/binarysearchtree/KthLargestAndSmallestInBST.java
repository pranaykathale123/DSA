package org.example.binarysearchtree;

public class KthLargestAndSmallestInBST {

    private int counter = 0;
    private int result = 0;

    // -------- Kth Smallest --------
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);

        counter++;
        if (counter == k) {
            result = root.val;
            return;
        }

        inorder(root.right, k);
    }

    public int kthLargest(TreeNode root, int k) {
        counter = 0;
        result = 0;
        reverseInorder(root, k);
        return result;
    }

    private void reverseInorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        reverseInorder(root.right, k);

        counter++;
        if (counter == k) {
            result = root.val;
            return;
        }

        reverseInorder(root.left, k);
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        /*
                BST Structure:
                     8
                   /   \
                  4     12
                 / \    / \
                2   6  10  14
        */

        TreeNode root = new TreeNode(
                8,
                new TreeNode(
                        4,
                        new TreeNode(2),
                        new TreeNode(6)
                ),
                new TreeNode(
                        12,
                        new TreeNode(10),
                        new TreeNode(14)
                )
        );

        int k = 3;

        KthLargestAndSmallestInBST obj = new KthLargestAndSmallestInBST();
        int kthLargest = obj.kthLargest(root, k);
        int kthSmallest = obj.kthSmallest(root, k);

        System.out.println(k + "rd smallest element in BST is: " + kthSmallest);
        System.out.println(k + "rd largest element in BST is: " + kthLargest);
    }
}
