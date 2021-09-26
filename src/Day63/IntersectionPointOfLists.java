package Day63;

//Write a function to get the intersection point of two Linked Lists
//Time Complexity: O(m+n)
//Auxiliary Space: O(1)
public class IntersectionPointOfLists {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static int getIntersectingNode(Node head1, Node head2) {
        int c1 = getCountOfNodes(head1);
        int c2 = getCountOfNodes(head2);
        int d;

        if(c1 > c2) {
            d = c1 - c2;
            return getNode(d, head1, head2);
        }
        else {
            d = c2 - c1;
            return getNode(d, head2, head1);
        }
    }

    static int getNode(int d, Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;
        for(int i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }
        while(current1 != null && current2 != null) {
            if(current1.data == current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }

    static int getCountOfNodes(Node head) {
        Node current = head;
        int count = 0;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    static void printList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(" " +current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node newNode = new Node(15);
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = newNode;
        newNode.next = new Node(30);

        Node head2 = new Node(10);
        head2.next = newNode;

        printList(head1);
        System.out.println();
        printList(head2);
        System.out.println("\nIntersecting node is " + getIntersectingNode(head1, head2));
    }
}
