package Day20;

//Given a singly linked list, find the middle of the linked list.
//For example, if the given linked list is 1->2->3->4->5 then the output should be 3.
//If there are even nodes, then there would be two middle nodes, we need to print the second middle element.
//For example, if given linked list is 1->2->3->4->5->6 then the output should be 4.

//Method 1: Traverse the whole linked list and count the no. of nodes. Now traverse the list again till count/2 and return the node at count/2.
//Method 2: Traverse linked list using two pointers.
//Move one pointer by one and the other pointer by two.
//When the fast pointer reaches the end slow pointer will reach the middle of the linked list.

public class MiddleOfLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printMiddle() {
        Node slowPtr = head;
        Node fastPtr = head;

        if (head != null) {
            while (fastPtr.next != null && fastPtr.next.next != null) {
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
            }
            System.out.println("The middle element is [" + slowPtr.data + "] \n");
        }
    }
    /* Inserts a new Node at front of the list. */
    public void push(int newData) {
        //Allocate the Node & Put in the data
        Node newNode = new Node(newData);
        //Make next of new Node as head
        newNode.next = head;
        //Move the head to point to new Node
        head = newNode;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        MiddleOfLinkedList list = new MiddleOfLinkedList();
        for (int i=5; i>0; --i) {
            list.push(i);
            list.printList();
            list.printMiddle();
        }
    }
}
