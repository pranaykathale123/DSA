package org.example.trees;

public class MaxPathSum {
    int maxValue = Integer.MIN_VALUE;

    // Method to return the maximum path sum
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }

    // Helper to compute downward max path + update global max
    private int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Only take positive contributions
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));

        // Path passing through this node
        maxValue = Math.max(maxValue, left + right + root.val);

        // Return best single-path sum going upward
        return root.val + Math.max(left, right);
    }

    // Main method
    public static void main(String[] args) {

        MaxPathSum sol = new MaxPathSum();

        /*
                 1
               /   \
              2     2
             /       \
            3         3
           /           \
          4             4

           Test case: [1,2,2,3,null,null,3,4,null,null,4]
         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);

        int result = sol.maxPathSum(root);
        System.out.println("Maximum Path Sum = " + result);
    }
}
