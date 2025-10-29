package org.example.linkedList;

public class LinkedListCycle2 {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to detect the start node of the cycle (if exists)
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                // Step 2: Find the node where the cycle begins
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Start of cycle
            }
        }
        return null; // No cycle
    }

    // Main method to test detectCycle
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // No cycle case
        ListNode noCycle = detectCycle(head);
        System.out.println("Cycle starts at: " + (noCycle != null ? noCycle.val : "null"));

        // Create a cycle: tail (5) -> node (3)
        head.next.next.next.next.next = head.next.next;

        // Detect cycle again
        ListNode cycleStart = detectCycle(head);
        System.out.println("Cycle starts at: " + (cycleStart != null ? cycleStart.val : "null"));
    }
}

