package org.example.trees;

public class diameterOfBinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        // Update diameter (leftHeight + rightHeight = number of edges)
        diameter = Math.max(diameter, left + right);

        // Return height of current node
        return Math.max(left, right) + 1;
    }

    // MAIN METHOD FOR TESTING
    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        // Construct tree: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        diameterOfBinaryTree sol = new diameterOfBinaryTree();
        int result = sol.diameterOfBinaryTree(root);

        System.out.println("Diameter of Binary Tree (in edges): " + result);
    }
}

