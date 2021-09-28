package Day65;

import java.util.HashMap;

//Given a linked list having two pointers in each node. The first one points to the next node of the list,
//however, the other pointer is random and can point to any node of the list. Write a program that clones the given list with next and random pointer.
//Time complexity : O(n)
//Auxiliary space : O(n)
//Deep copy
public class CopyListWithRandomPointers {
    static class Node {
        int data;
        Node next;
        Node random;

        Node(int d) {
            data = d;
            next = null;
            random = null;
        }
    }

    static Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;
        Node newHead = new Node(-1); //which is the copy of the original one
        Node prev = newHead;

        //For next links and clone the exact data and put the mappings of both lists in map.
        while(current != null) {
            prev.next = new Node(current.data); //we can't do prev.next = current, since we need separate address for both lists
            // and prev.next = current will point to the same node.
            map.put(current, prev.next);
            prev = prev.next;
            current = current.next;
        }
        newHead = newHead.next;
        Node current1 = head;
        Node current2 = newHead;

        //For random pointer links
        while(current1 != null) {
            current2.random = current1.random != null ? map.get(current1.random) : null;
            current1 = current1.next;
            current2 = current2.next;
        }

        return newHead;
    }

    static void printList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        //For next links
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        //For random links
        head.random = head;
        head.next.random = head.next.next.next.next;
        head.next.next.random = head;
        head.next.next.next.random = head.next;
        head.next.next.next.next.random = null;

        System.out.println("Original list is : ");
        printList(head);

        Node result = copyRandomList(head);
        System.out.println("\nCloned list is : ");
        printList(result);

    }

}
