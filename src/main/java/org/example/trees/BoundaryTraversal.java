package org.example.trees;

import java.util.ArrayList;

public class BoundaryTraversal {
    public ArrayList<Integer> boundary(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;

        result.add(node.val);
        if (node.left == null && node.right == null) {
            return result;
        }

        leftBoundary(node, result);
        addLeaves(node, result);
        rightBoundary(node, result);

        return result;
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    private void leftBoundary(TreeNode root, ArrayList<Integer> result) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                result.add(curr.val);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeaves(TreeNode root, ArrayList<Integer> result) {
        if (isLeaf(root)) {
            result.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, result);
        if (root.right != null) addLeaves(root.right, result);
    }

    private void rightBoundary(TreeNode root, ArrayList<Integer> result) {
        ArrayList<Integer> temp = new ArrayList<>();
        TreeNode curr = root.right;
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.val);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BoundaryTraversal bt = new BoundaryTraversal();
        System.out.println(bt.boundary(root));
    }
}
