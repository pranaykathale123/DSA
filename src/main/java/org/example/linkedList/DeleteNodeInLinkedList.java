package org.example.linkedList;

public class DeleteNodeInLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to delete the given node (not tail)
    public static void deleteNode(ListNode node) {
        // Copy value from next node and skip the next node
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Utility method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test the logic
    public static void main(String[] args) {
        // Create linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.print("Original List: ");
        printList(head);

        // Let's delete the node with value 5 (not the tail)
        ListNode nodeToDelete = head.next; // node with value 5
        deleteNode(nodeToDelete);

        System.out.print("After Deletion: ");
        printList(head);
    }
}

