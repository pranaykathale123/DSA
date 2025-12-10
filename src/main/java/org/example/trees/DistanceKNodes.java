package org.example.trees;

import java.util.*;

public class DistanceKNodes {

    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parents_track) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (current.left != null) {
                q.offer(current.left);
                parents_track.put(current.left, current);
            }

            if (current.right != null) {
                q.offer(current.right);
                parents_track.put(current.right, current);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parents_track = new HashMap<>();
        markParents(root, parents_track);

        int currentLevel = 0;

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        visited.put(target, true);
        queue.offer(target);

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (currentLevel == k)
                break;

            currentLevel++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }

                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }

                TreeNode parent = parents_track.get(current);
                if (parent != null && visited.get(parent) == null) {
                    queue.offer(parent);
                    visited.put(parent, true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val




            );
        }

        return result;
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

                target = 5, k = 2

                Nodes at distance 2 from 5 → [7, 4, 1]
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

        DistanceKNodes solver = new DistanceKNodes();

        TreeNode target = root.left; // Node 5
        int k = 2;

        List<Integer> result = solver.distanceK(root, target, k);

        System.out.println("Nodes at distance " + k + " from target (" + target.val + "): " + result);
    }

}
