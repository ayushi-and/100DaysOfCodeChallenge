package Day25;

public class DeleteMiddleOfLinkedList {
    Node head;
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void deleteMid() {
        if(head != null) {
            Node slowPtr = head;
            Node fastPtr = head;
            Node prev = null;
            while(fastPtr.next != null && fastPtr.next.next != null) {
                fastPtr = fastPtr.next.next;
                prev = slowPtr;
                slowPtr = slowPtr.next;
            }
            if(prev != null) {
                prev.next = slowPtr.next;
            }
        }
    }

    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
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
        DeleteMiddleOfLinkedList list = new DeleteMiddleOfLinkedList();
        for (int i=5; i>0; --i) {
            list.push(i);
        }
        list.printList();
        list.deleteMid();
        list.printList();
    }
}
