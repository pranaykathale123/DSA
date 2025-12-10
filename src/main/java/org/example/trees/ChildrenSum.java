package org.example.trees;

public class ChildrenSum {

    public static void changeTree(TreeNode root) {
        if (root == null) return;

        int child = 0;

        if (root.left != null) {
            child += root.left.val;
        }
        if (root.right != null) {
            child += root.right.val;
        }

        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if (root.left != null) tot += root.left.val;
        if (root.right != null) tot += root.right.val;

        if (root.left != null || root.right != null) {
            root.val = tot;
        }
    }

    // Helper: preorder print
    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        /*
                 Example tree:
                       40
                     /    \
                   10      20
                  /  \       \
                 2    5      30
         */

        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(30);

        System.out.println("Before changeTree:");
        printTree(root);
        System.out.println();

        changeTree(root);

        System.out.println("After changeTree:");
        printTree(root);
    }
}
