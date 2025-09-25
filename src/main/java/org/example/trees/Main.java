package org.example.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value for root node (0 for null): ");
        int rootVal = sc.nextInt();
        if (rootVal == 0) {
            System.out.println("Empty tree.");
            return;
        }
        TreeNode root = new TreeNode(rootVal);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print("Enter left child of " + current.val + " (0 for null): ");
            int leftVal = sc.nextInt();
            if (leftVal != 0) {
                current.left = new TreeNode(leftVal);
                queue.offer(current.left);
            }
            System.out.print("Enter right child of " + current.val + " (0 for null): ");
            int rightVal = sc.nextInt();
            if (rightVal != 0) {
                current.right = new TreeNode(rightVal);
                queue.offer(current.right);
            }
        }

        // Now you can perform traversals on root

        // Perform different tree traversals
        System.out.println("Pre-order Traversal:");
        PreOrderTraversal.preOrder(root);
        System.out.println();

        System.out.println("In-order Traversal:");
        InOrderTraversal.inOrder(root);
        System.out.println();

        System.out.println("Post-order Traversal:");
        PostOrderTraversal.postOrder(root);
        System.out.println();

        System.out.println("Level-order Traversal:");
        LevelOrderTraversal.levelOrder(root);
        System.out.println();
    }
}
