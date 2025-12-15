package org.example.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerialiseAndDeserialiseBinarytree {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                str.append("n ");
                continue;
            }
            //added space after each value for easy splitting later
            str.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode node = q.poll();

            // left child
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.offer(left);
            }

            // right child
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.offer(right);
            }
        }
        return root;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        // Creating a sample tree:
        //         1
        //       /   \
        //      2     3
        //           / \
        //          4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize
        String serialized = serialize(root);
        System.out.println("Serialized Tree:");
        System.out.println(serialized);

        // Deserialize
        TreeNode deserializedRoot = deserialize(serialized);
        System.out.println("Deserialization completed!");

        // Confirm by printing root node value
        System.out.println("Root of Deserialized Tree: " + deserializedRoot.val);
    }
}
