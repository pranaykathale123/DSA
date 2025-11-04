package org.example.linkedList;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // Step 1: Find the kth node from groupPrev
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) break; // Not enough nodes left

            ListNode nextGroupHead = kth.next;

            // Step 2: Reverse the group
            ListNode groupStart = groupPrev.next;
            reverse(groupStart, kth);

            // Step 3: Reconnect pointers
            groupPrev.next = kth; // kth becomes new head of this group
            groupStart.next = nextGroupHead; // old head now tail connects to next group

            // Step 4: Move groupPrev forward for next iteration
            groupPrev = groupStart;
        }

        return dummy.next;
    }

    // Helper: Get kth node from current
    private static ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // Helper: Reverse nodes from 'start' to 'end' inclusive
    private static void reverse(ListNode start, ListNode end) {
        ListNode prev = end.next;
        ListNode curr = start;

        while (prev != end) { // stop when prev == end
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }

    // 🧪 Utility: Print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    // 🧪 Utility: Create a linked list from array
    private static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup sol = new ReverseNodesInKGroup();

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        ListNode head = createList(arr);
        System.out.print("Original List: ");
        printList(head);

        ListNode newHead = sol.reverseKGroup(head, k);

        System.out.print("Reversed in Groups of " + k + ": ");
        printList(newHead);
    }
}
