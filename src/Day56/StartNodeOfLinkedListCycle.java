package Day56;

//Given the head of a Singly LinkedList that contains a cycle,
//write a function to find the starting node of the cycle.

public class StartNodeOfLinkedListCycle {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //USING HASHING APPROACH
    /*static Node startOfLinkedListCycle(Node head) {
        Set<Node> set = new HashSet<>();
        Node current = head;

        while(current != null) {
            if(set.contains(current)) {
                return current;
            }
            else {
                set.add(current);
            }
            current = current.next;
        }
        return null;
    }*/

    //USING TWO POINTERS
    static Node startOfLinkedListCycle(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr) {
                return calculateStart(slowPtr, head);
            }
        }
        return null;
    }

    static Node calculateStart(Node p1, Node p2) {
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next.next;

        System.out.println(startOfLinkedListCycle(head).data);
    }
}
