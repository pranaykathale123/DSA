package org.example.linkedList;

import java.util.Scanner;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val)
    {
        this.val = val;

    }
    ListNode(){}

    public static ListNode insertNode() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes to insert: ");
        int size = scanner.nextInt();

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < size; i++) {
            System.out.print("Enter value for node " + (i + 1) + ": ");
            int value = scanner.nextInt();

            ListNode newNode = new ListNode(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;//updating tail
            }
        }

        return head;
    }
    // Utility method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    //Find length of Linked List
    public static int findLenghOfLL(ListNode head){
       int count = 1;
       ListNode current = head;
       while(current.next!=null){
          current = current.next;
          count++;
       }
       System.out.println("the count of LinkedList is: "+ count);
       return count;
    }
    //search for an Element in a LL
    public static void searchElement(ListNode head){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter an element to be searched");
        int x = scanner.nextInt();
        ListNode current = head;
        boolean found = false;
        while(current!= null){
            if(current.val == x){
                System.out.println("Element found in a LL");
                found = true;
                break;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No such element found in the LL");
        }
    }
}
