package org.example.linkedList;

public class LinkedListCycle {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to detect if the linked list has a cycle
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }

    // Main method to test the hasCycle function
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // No cycle case
        System.out.println("Has Cycle (Expected false): " + hasCycle(head));

        // Create a cycle manually: 5 -> 3
        head.next.next.next.next.next = head.next.next; // Node 5 points to Node 3
        System.out.println("Has Cycle (Expected true): " + hasCycle(head));
    }
}

