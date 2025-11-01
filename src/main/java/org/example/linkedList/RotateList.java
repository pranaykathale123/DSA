package org.example.linkedList;

public class RotateList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length of the list
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        // Step 2: Make list circular
        curr.next = head;

        // Step 3: Normalize k
        k = k % len;

        // Step 4: Find new tail (len - k steps)
        int stepsToNewTail = len - k;
        while (stepsToNewTail-- > 0) {
            curr = curr.next;
        }

        // Step 5: Break the loop and set new head
        head = curr.next;
        curr.next = null;

        return head;
    }

    // Utility function to print a linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        int k = 2;
        head = rotateRight(head, k);

        System.out.print("Rotated List by " + k + ": ");
        printList(head);
    }
}

