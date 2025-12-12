package org.example.trees;

import java.util.*;

public class BurningTree {

    // This method matches the signature you gave in Solution
    public static int minTime(TreeNode root, int target) {
        if (root == null) return 0;

        // Step 1: BFS to map each node to its parent and also find the target node reference
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode = mapParentsAndFindTarget(root, parentMap, target);
        if (targetNode == null) {
            // target value not found in tree
            return 0;
        }

        // Step 2: BFS from target node to simulate burning
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(targetNode);
        visited.add(targetNode);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burnedSomethingThisLevel = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                    burnedSomethingThisLevel = true;
                }

                // right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                    burnedSomethingThisLevel = true;
                }

                // parent
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    q.offer(parent);
                    visited.add(parent);
                    burnedSomethingThisLevel = true;
                }
            }

            // if we spread to any new node in this level, it takes 1 unit time
            if (burnedSomethingThisLevel) time++;
        }

        return time;
    }

    // Helper: BFS to map parents and find the TreeNode with given target value
    private static TreeNode mapParentsAndFindTarget(TreeNode root, Map<TreeNode, TreeNode> parentMap, int target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode targetNode = null;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.val == target) targetNode = curr;

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        return targetNode;
    }

    // MAIN for demo / testing
    public static void main(String[] args) {
        /*
            Example tree:
                     1
                    / \
                   2   3
                  / \   \
                 4   5   6
                    /
                   7

            If target = 5
            Burn sequence (one possible): 5 -> 2 & 7 -> 1 & 4 -> 3 -> 6
            Minimum time expected: 4
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);

        int target = 5;

        int result = minTime(root, target);

        System.out.println("Minimum time to burn the whole tree from target " + target + " = " + result);
    }
}
