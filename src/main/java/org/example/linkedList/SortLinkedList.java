package org.example.linkedList;

public class SortLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Step 1: Find middle using slow-fast pointer
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split into two halves
        ListNode mid = slow.next;
        slow.next = null;

        // Step 3: Sort each half recursively
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Step 4: Merge the two sorted halves
        return mergeTwoSortedLinkedLists(left, right);
    }

    public ListNode mergeTwoSortedLinkedLists(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode mergedHead;

        if (head1.val <= head2.val) {
            mergedHead = head1;
            mergedHead.next = mergeTwoSortedLinkedLists(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = mergeTwoSortedLinkedLists(head1, head2.next);
        }

        return mergedHead;
    }

    // Utility method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create unsorted linked list: 4 -> 2 -> 1 -> 3
        ListNode n4 = new ListNode(3);
        ListNode n3 = new ListNode(1, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(4, n2);

        System.out.print("Original List: ");
        printList(n1);

        // Sort the list
        SortLinkedList solution = new SortLinkedList();
        ListNode sortedHead = solution.sortList(n1);

        System.out.print("Sorted List: ");
        printList(sortedHead);
    }
}

