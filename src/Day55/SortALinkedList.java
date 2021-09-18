package Day55;

//Sort the nodes of a Singly Linked list in ascending order
//Using Bubble Sort
public class SortALinkedList {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void sortList(Node head) {
        Node current = head;
        Node index = null;
        if(head == null) {
            return;
        }
        else {
            while(current != null) {
                index = current.next;
                while(index != null) {
                    if(current.data > index.data) {
                        int temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void printList(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(2);
        head.next.next = new Node(8);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(20);
        head.next.next.next.next.next = new Node(12);

        SortALinkedList list = new SortALinkedList();
        list.printList(head);
        list.sortList(head);
        list.printList(head);
    }
}
