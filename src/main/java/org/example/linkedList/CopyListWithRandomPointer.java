package org.example.linkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyListWithRandomPointer {
    // 🧠 Approach 1: Using HashMap (O(n) space)
    public Node copyRandomListUsingMap(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // Step 1: Create all nodes and store mapping
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers
        curr = head;
        while (curr != null) {
            Node clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    // ⚙️ Approach 2: Optimized O(1) Space
    public Node copyRandomListOptimized(Node head) {
        if (head == null) return null;

        Node temp = head;

        // Step 1: Insert clone nodes in between original nodes
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        // Step 2: Assign random pointers for cloned nodes
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the cloned list from the original
        Node dummy = new Node(0);
        Node copy = dummy;
        temp = head;

        while (temp != null) {
            copy.next = temp.next;
            temp.next = temp.next.next;
            copy = copy.next;
            temp = temp.next;
        }

        return dummy.next;
    }

    // 🧪 Main for Testing
    public static void main(String[] args) {
        // Create test list: 1 -> 2 -> 3
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // Random pointers
        head.random = head.next.next;        // 1 → random → 3
        head.next.random = head;             // 2 → random → 1
        head.next.next.random = head.next;   // 3 → random → 2

        CopyListWithRandomPointer sol = new CopyListWithRandomPointer();

        System.out.println("Using HashMap:");
        Node clone1 = sol.copyRandomListUsingMap(head);
        printLists(head, clone1);

        System.out.println("\nUsing Optimized O(1) Space:");
        Node clone2 = sol.copyRandomListOptimized(head);
        printLists(head, clone2);
    }

    private static void printLists(Node orig, Node clone) {
        while (orig != null && clone != null) {
            System.out.println(
                    "Original: " + orig.val +
                            " (Random: " + (orig.random != null ? orig.random.val : "null") + ")" +
                            " | Clone: " + clone.val +
                            " (Random: " + (clone.random != null ? clone.random.val : "null") + ")"
            );
            orig = orig.next;
            clone = clone.next;
        }
    }
}
