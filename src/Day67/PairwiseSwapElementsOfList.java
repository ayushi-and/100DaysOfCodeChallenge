package Day67;

//Given a singly linked list, write a function to swap elements pairwise.
//Input : 1->2->3->4->5->6->NULL
//Output : 2->1->4->3->6->5->NULL
//Time complexity: O(n)
public class PairwiseSwapElementsOfList {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Iterative
    static void pairWiseSwap(Node head) {
        Node current = head;

        while(current != null && current.next != null) {
            int k = current.data;
            current.data = current.next.data;
            current.next.data = k;
            current = current.next.next;
        }
    }

    //Recursive
    static void pairWiseSwapUsingRecursion(Node head) {
        if(head != null && head.next != null) {
            //swap(head.data, head.next.data);
            int temp = head.data;
            head.data = head.next.data;
            head.next.data = temp;
            pairWiseSwapUsingRecursion(head.next.next);
        }
    }

    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        printList(head);

        pairWiseSwapUsingRecursion(head);
        System.out.println();
        printList(head);
    }
}
