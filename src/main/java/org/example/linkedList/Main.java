package org.example.linkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListNode obj = new ListNode();
        ListNode head = obj.insertNode();
        obj.printList(head);
        obj.findLenghOfLL(head);
        obj.searchElement(head);
    }
}