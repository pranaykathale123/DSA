package org.example.trees;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root; // Both sides found → this is LCA
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        /*
                Example Tree:
                         3
                       /   \
                      5     1
                     / \   / \
                    6  2  0   8
                      / \
                     7   4
                p = 5, q = 1  → LCA = 3
                p = 6, q = 4  → LCA = 5
         */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();
        TreeNode p = root.left;            // Node 5
        TreeNode q = root.right;           // Node 1
        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);

        System.out.println("LCA of 5 and 1 = " + lca.val);

        TreeNode p2 = root.left.left;      // Node 6
        TreeNode q2 = root.left.right.right; // Node 4
        TreeNode lca2 = lcaFinder.lowestCommonAncestor(root, p2, q2);

        System.out.println("LCA of 6 and 4 = " + lca2.val);
    }

    }
