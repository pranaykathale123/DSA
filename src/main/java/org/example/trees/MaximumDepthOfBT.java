package org.example.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfBT {

    // Recursive method to find maximum depth or DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHand = maxDepth(root.left);
        int rightHand = maxDepth(root.right);

        return 1 + Math.max(leftHand, rightHand);
    }

    // BFS method to find maximum depth
    public int maxDepthIterative(TreeNode root) {

        List<List<Integer>> wraplist = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return 0;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < levelNum; i++) {

                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }

                subList.add(queue.poll().val);
            }

            wraplist.add(subList);
        }

        return wraplist.size();
    }


    // Main method to test
    public static void main(String[] args) {

        MaximumDepthOfBT sol = new MaximumDepthOfBT();

        /*
               1
              / \
             2   3
            / \
           4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        int depth = sol.maxDepth(root);
        int iterativeDepth = sol.maxDepthIterative(root);

        System.out.println("Maximum Depth of the Tree (Recursive): " + depth);
        System.out.println("Maximum Depth of the Tree (Iterative): " + iterativeDepth);
    }
}

