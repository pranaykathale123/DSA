package org.example.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterative {
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Method for Preorder Traversal (Iterative)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //stack -->
        //result --> 1,2,4,5,3,6
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            // Push right first so that left is processed first (LIFO order)
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }

    // Main method to test the traversal
    public static void main(String[] args) {
        /*
               1
              / \
             2   3
            / \   \
           4   5   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3, null, new TreeNode(6));

        PreOrderIterative solution = new PreOrderIterative();
        List<Integer> preorder = solution.preorderTraversal(root);

        System.out.println("Preorder Traversal: " + preorder);
    }
    //root
    //left
    //right
}
