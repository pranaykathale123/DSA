package org.example.linkedList;

public class IntersectionOfTwoLinkedLists {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Core logic: Find intersection node
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists; when one reaches end, start from the other
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // Either intersection node or null
        return a;
    }

    // Utility method to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
         Example:
         List A: 1 → 9 → 1 ↘
                             2 → 4
                       ↗
         List B:       3
         Intersection at node with value 2
        */

        // Shared part
        ListNode intersect = new ListNode(2);
        intersect.next = new ListNode(4);

        // List A
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = intersect; // connect to intersection

        // List B
        ListNode headB = new ListNode(3);
        headB.next = intersect; // connect to intersection

        System.out.print("List A: ");
        printList(headA);

        System.out.print("List B: ");
        printList(headB);

        ListNode result = getIntersectionNode(headA, headB);

        if (result != null)
            System.out.println("Intersection at node with value: " + result.val);
        else
            System.out.println("No intersection found.");
    }
}

