package org.example.trees;

import java.util.ArrayList;
import java.util.List;

public class LeftView {

    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftSideView(root, result, 0);
        return result;
    }

    private static void leftSideView(TreeNode root, List<Integer> result, int currDepth) {
        if (root == null) {
            return;
        }

        // If this is the first node we see at this depth
        if (result.size() == currDepth) {
            result.add(root.val);
        }

        // Right first, then left
        leftSideView(root.right, result, currDepth + 1);
        leftSideView(root.left, result, currDepth + 1);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        // Example Tree:
        //        1
        //      /   \
        //     2     3
        //      \     \
        //       5     4
        //
        // Right view = [1, 3, 4]

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> leftview = leftSideView(root);

        System.out.println("Right Side View: " + leftview);
    }

//    public List<Integer> rightView(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode curr = q.poll();
//
//                if (i == 0) result.add(curr.val); // last node of this level
//
//                if (curr.left != null) q.offer(curr.left);
//                if (curr.right != null) q.offer(curr.right);
//            }
//        }
//        return result;
//    }

}

