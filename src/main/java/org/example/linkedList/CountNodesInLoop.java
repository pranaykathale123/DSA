package org.example.linkedList;

public class CountNodesInLoop {

    // Definition for singly linked list node
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to find the length of a loop in the linked list
    static int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        int count = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected
            if (slow == fast) {
                Node temp = slow;

                while (temp.next != fast) {
                    count++;
                    temp = temp.next;
                }
                return count + 1; // Include the meeting node itself
            }
        }
        return count; // 0 if no loop
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a loop: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        int loopLength = countNodesinLoop(head);
        System.out.println("Length of the loop: " + loopLength);

        // Example 2: No loop
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);

        int loopLength2 = countNodesinLoop(head2);
        System.out.println("Length of the loop: " + loopLength2);
    }
}

