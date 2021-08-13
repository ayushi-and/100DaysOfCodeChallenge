package Day30;

//Given a singly linked list, rotate the linked list counter-clockwise by k nodes.
//Where k is a given positive integer. For example, if the given linked list is 10->20->30->40->50->60 and k is 4,
//the list should be modified to 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in a linked list.
public class RotateALinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node tnode = head;
        while(tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    //k = 4, list = 10->20->30->40->50->60
    //O/P = 50->60->10->20->30->40
    public void rotate(int k) {
        if(k == 0) {
            return;
        }
        Node current =  head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = head;
        current = head;

        for(int i = 0; i < k-1; i++) {
            current = current.next;
        }
        head = current.next;
        current.next = null;
    }

    public static void main(String[] args) {
        RotateALinkedList list = new RotateALinkedList();
        list.push(60);
        list.push(50);
        list.push(40);
        list.push(30);
        list.push(20);
        list.push(10);

        list.printList();
        list.rotate(4);
        System.out.println();
        list.printList();
    }
}
