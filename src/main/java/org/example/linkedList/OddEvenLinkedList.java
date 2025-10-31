package org.example.linkedList;

public class OddEvenLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode oddEvenList(ListNode head) {
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null) return head;

        // odd points to the first node (1st), even points to the second node (2nd)
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // store start of even list to connect later

        // Traverse till either even or even.next is null
        while (even != null && even.next != null) {
            // Connect odd nodes together
            odd.next = odd.next.next;
            odd = odd.next;

            // Connect even nodes together
            even.next = even.next.next;
            even = even.next;
        }

        // After traversal, connect last odd node to the head of even list
        odd.next = evenHead;

        return head;
    }

    // Utility method to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        // Example: 1 → 2 → 3 → 4 → 5
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4); n4.next = n5;
        ListNode n3 = new ListNode(3); n3.next = n4;
        ListNode n2 = new ListNode(2); n2.next = n3;
        ListNode n1 = new ListNode(1); n1.next = n2;

        System.out.print("Original List: ");
        printList(n1);

        ListNode result = oddEvenList(n1);

        System.out.print("Odd-Even Reordered List: ");
        printList(result);
    }
}

