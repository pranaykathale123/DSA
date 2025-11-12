package org.example.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderIterative {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if (root == null) {
            return inorder;
        }

        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                node = st.pop();
                inorder.add(node.val);
                node = node.right;
            }
        }

        return inorder;
    }

    /*
               1
              / \
             2   3
            / \   \
           4   5   6
     */
    //4,2,5,1,3,6
    public static void main(String[] args) {
        InOrderIterative obj = new InOrderIterative();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = obj.inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result);
    }
    //left, root, right
}
