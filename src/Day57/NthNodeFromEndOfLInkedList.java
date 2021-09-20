package Day57;

public class NthNodeFromEndOfLInkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static void getNthNodeFromLast(Node head, int n) {
        Node mainPointer = head;
        Node referencePointer = head;

        int count = 0;
        if(head != null) {
            while(count < n) {
                referencePointer = referencePointer.next;
                count++;
            }
            while(referencePointer != null) {
                mainPointer = mainPointer.next;
                referencePointer = referencePointer.next;
            }
            System.out.println("Node no. " + n + " from last is " + mainPointer.data);
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        getNthNodeFromLast(head, 2);
    }
}
