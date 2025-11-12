package org.example.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterative {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> postorder = new ArrayList<>();

        if (root == null) {
            return postorder;
        }

        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode current = st1.pop();
            st2.push(current);

            if (current.left != null) {
                st1.push(current.left);
            }

            if (current.right != null) {
                st1.push(current.right);
            }
        }

        while (!st2.isEmpty()) {
            postorder.add(st2.pop().val);
        }

        return postorder;
    }

    public static void main(String[] args) {
        PostOrderIterative obj = new PostOrderIterative();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = obj.postorderTraversal(root);
        System.out.println("Postorder Traversal: " + result);
    }
}
