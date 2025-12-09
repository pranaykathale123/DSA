package org.example.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

    // Function to return bottom view of the binary tree
    static ArrayList<Integer> bottomView(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;

            // For bottom view → ALWAYS overwrite
            map.put(hd, node.val);

            if (node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
            }
        }

        result.addAll(map.values());
        return result;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        // Example binary tree:
        //         1
        //       /   \
        //      2     3
        //       \   / \
        //        4 5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        ArrayList<Integer> result = bottomView(root);

        System.out.println("Bottom View: " + result);
    }
}
