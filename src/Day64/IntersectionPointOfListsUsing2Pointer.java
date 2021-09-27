package Day64;

//Write a function to get the intersection point of two Linked Lists
//Time Complexity: O(m+n)
//Auxiliary Space: O(1)
public class IntersectionPointOfListsUsing2Pointer {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node getIntersectingNode(Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;

        if(current1 == null || current2 == null) {
            return null;
        }

        while(current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;

            if(current1 == current2) {
                return current1;
            }
            if(current1 == null) {
                current1 = head2;
            }
            if(current2 == null) {
                current2 = head1;
            }
        }
        return current1;
    }

    static void printList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(" " + current.data);
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
        System.out.println();
        Node result = getIntersectingNode(head1, head2);
        printList(result);
    }
}
