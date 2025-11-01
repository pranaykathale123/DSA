package org.example.linkedList;

public class FlattenLinkedList {

    // Definition of Node
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    // Function to flatten the linked list
    Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        // Recur for the list on the right
        root.next = flatten(root.next);

        // Merge this list with the flattened right list
        root = mergeTwoList(root, root.next);

        return root;
    }

    // Helper function to merge two bottom-linked sorted lists
    private Node mergeTwoList(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        // Attach remaining nodes
        if (a != null) temp.bottom = a;
        else temp.bottom = b;

        return res.bottom;
    }

    // Helper function to print the flattened list
    void printList(Node root) {
        Node curr = root;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.bottom;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        FlattenLinkedList list = new FlattenLinkedList();

        // Create the linked list as per the given example
        Node head = new Node(5);
        Node n10 = new Node(10);
        Node n19 = new Node(19);
        Node n28 = new Node(28);

        // Connect next pointers (horizontal)
        head.next = n10;
        n10.next = n19;
        n19.next = n28;

        // Connect bottom pointers (vertical)
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);

        n10.bottom = new Node(20);

        n19.bottom = new Node(22);

        n28.bottom = new Node(40);
        n28.bottom.bottom = new Node(45);

        // Flatten the list
        Node result = list.flatten(head);

        // Print the flattened list
        System.out.println("Flattened linked list:");
        list.printList(result);
    }
}


/*
Given Linked List (from the image)
5 → 10 → 19 → 28
|    |    |     |
7    20   22    40
|          |      |
8          NULL   45

🧠 Step 1: Start the recursion

Call:

flatten(5)


Since root = 5, root.next = 10.
So first line of recursion says:

root.next = flatten(root.next)


👉 means
root.next = flatten(10)

This starts recursion on the next column.

🧩 Step 2: Keep recursing rightward until the end
flatten(5)
  → flatten(10)
      → flatten(19)
          → flatten(28)


When we reach flatten(28):

root = 28

root.next = null
✅ So base case triggers — return root;

That means:

flatten(28) → returns the list: 28 ↓ 40 ↓ 45

🧩 Step 3: Go one step back — flatten(19)

Now we’re at:

root = 19
root.next = 28 (the flattened list from step above)


Now we do:

root.next = flatten(root.next);  // already flattened to 28→...
root = mergeTwoList(19, 28);

Merging (19 ↓ 22) and (28 ↓ 40 ↓ 45):
19 < 28 → pick 19
22 < 28 → pick 22
a (null) → attach rest of b (28 ↓ 40 ↓ 45)


Merged result:

19 ↓ 22 ↓ 28 ↓ 40 ↓ 45


Return this as flattened list for flatten(19).

🧩 Step 4: Back again — flatten(10)

Now:

root = 10
root.next = 19 (already flattened to 19 ↓ 22 ↓ 28 ↓ 40 ↓ 45)


Now merge:

(10 ↓ 20)  with  (19 ↓ 22 ↓ 28 ↓ 40 ↓ 45)


→ Result:

10 ↓ 19 ↓ 20 ↓ 22 ↓ 28 ↓ 40 ↓ 45


Return that.

🧩 Step 5: Finally — flatten(5)

Now:

root = 5
root.next = 10 (already flattened to 10 ↓ 19 ↓ 20 ↓ 22 ↓ 28 ↓ 40 ↓ 45)


Now merge:

(5 ↓ 7 ↓ 8) with (10 ↓ 19 ↓ 20 ↓ 22 ↓ 28 ↓ 40 ↓ 45)


→ Final merged list:

5 ↓ 7 ↓ 8 ↓ 10 ↓ 19 ↓ 20 ↓ 22 ↓ 28 ↓ 40 ↓ 45


Return this as final flattened list.

🔁 So to your question — “which next is being called?”

Each recursion step calls flatten() on the next horizontal list:

Call	root	root.next (flattened)	Action
flatten(5)	5	flatten(10)	merge(5, 10...)
flatten(10)	10	flatten(19)	merge(10, 19...)
flatten(19)	19	flatten(28)	merge(19, 28...)
flatten(28)	28	null	base case → return 28

So flatten(root.next) recursively flattens the right side first, then merges it backward (like merge sort).

🧩 Intuition summary

Think of it like flattening a 2D list from right to left:

28 list → flatten itself
then merge (19 list) with flattened 28
then merge (10 list) with that
then merge (5 list) with that
*/





