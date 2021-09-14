package Day52;

//Given the head of a LinkedList with a cycle, find the length of the cycle.
public class LengthOfLinkedListCycle {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

     static int getLengthOfLinkedListCycle(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr) {
                return lengthOfCycle(slowPtr);
            }
        }
        return 0;
    }

     static int lengthOfCycle(Node slowPtr) {
        int count = 1;
        Node current = slowPtr;

        while(current.next != slowPtr) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next.next;

        System.out.println(getLengthOfLinkedListCycle(head));
    }
}
