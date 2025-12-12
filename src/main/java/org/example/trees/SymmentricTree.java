package org.example.trees;

public class SymmentricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null || left.val != right.val)
            return false;

        return isSymmetricHelper(left.left, right.right) &&
                isSymmetricHelper(left.right, right.left);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        /*
               Symmetric Example:

                     1
                   /   \
                  2     2
                 / \   / \
                3  4  4   3
        */

        TreeNode symmetricRoot = new TreeNode(1);
        symmetricRoot.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        symmetricRoot.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

        System.out.println("Is tree symmetric? " + isSymmetric(symmetricRoot)); // true


        /*
               Non-Symmetric Example:

                     1
                   /   \
                  2     2
                   \      \
                    3      3
        */

        TreeNode nonSymmetricRoot = new TreeNode(1);
        nonSymmetricRoot.left = new TreeNode(2, null, new TreeNode(3));
        nonSymmetricRoot.right = new TreeNode(2, null, new TreeNode(3));

        System.out.println("Is tree symmetric? " + isSymmetric(nonSymmetricRoot)); // false
    }
}
