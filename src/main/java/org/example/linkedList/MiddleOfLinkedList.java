package org.example.linkedList;

public class MiddleOfLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Method to find the middle node of a linked list
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test the middleNode method
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Find and print the middle node
        ListNode middle = middleNode(head);
        System.out.println("Middle Node Value: " + middle.val);

        // Example with even number of nodes: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode evenHead = new ListNode(1);
        evenHead.next = new ListNode(2);
        evenHead.next.next = new ListNode(3);
        evenHead.next.next.next = new ListNode(4);
        evenHead.next.next.next.next = new ListNode(5);
        evenHead.next.next.next.next.next = new ListNode(6);

        System.out.println("\nEven Length List:");
        printList(evenHead);

        ListNode evenMiddle = middleNode(evenHead);
        System.out.println("Middle Node Value: " + evenMiddle.val);
    }
}

