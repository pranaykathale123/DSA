package org.example.trees;

import java.util.ArrayList;

public class RootToLeaf {

    public ArrayList<ArrayList<Integer>> Paths(TreeNode root) {

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();

        if (root != null) {
            pathsHelper(root, currentPath, answer);
        }

        return answer;
    }

    private void pathsHelper(TreeNode root, ArrayList<Integer> currentPath,
                             ArrayList<ArrayList<Integer>> answer) {

        if (root == null) {
            return;
        }

        currentPath.add(root.val);

        // Leaf node → store path
        if (root.left == null && root.right == null) {
            answer.add(new ArrayList<>(currentPath));
        } else {
            pathsHelper(root.left, currentPath, answer);
            pathsHelper(root.right, currentPath, answer);
        }

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    }
}

