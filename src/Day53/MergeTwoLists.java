package Day53;

//Merge two linkedLists
public class MergeTwoLists {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static void mergeLists(Node head1, Node head2) {
        if(head1 == null) {
            System.out.println("First list is empty.");
            return;
        }
        if(head2 == null) {
            System.out.println("Second list is empty.");
            return;
        }
        Node current1 = head1;
        while(current1.next != null) {
            current1 = current1.next;
        }
        current1.next = head2;

        while(head1 != null) {
            System.out.print(" " + head1.data);
            head1 = head1.next;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(6);

        mergeLists(head1, head2);
    }
}
