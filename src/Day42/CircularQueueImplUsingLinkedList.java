package Day42;

public class CircularQueueImplUsingLinkedList {

    Node front, rear;

    CircularQueueImplUsingLinkedList() {
        front = null;
        rear = null;
    }
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    boolean isEmpty() {
        return front == null;
    }

    void enQueue(int key) {
        Node newNode = new Node(key);
        if(isEmpty()) {
            front = newNode;
        }
        else {
            rear.next = newNode;
        }
        rear = newNode;
        rear.next = front;
    }

    int deQueue() {
        int key;
        if(isEmpty()) {
            System.out.println("Queue is empty, Underflow!");
            return Integer.MIN_VALUE;
        }
        else if (front == rear) {
            key = front.data;
            front = null;
            rear = null;
        }
        else {
            key = front.data;
            front = front.next;
            rear.next = front;
        }
        return key;
    }

    void displayQueue() {
        Node temp = front;
        while(temp.next != front) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String args[])
    {
        CircularQueueImplUsingLinkedList queue = new CircularQueueImplUsingLinkedList();

        queue.enQueue(14);
        queue.enQueue(22);
        queue.enQueue(6);

        queue.displayQueue();

        System.out.println("Deleted value "+ queue.deQueue());
        System.out.println("Deleted value "+ queue.deQueue());

        queue.displayQueue();

        queue.enQueue(9);
        queue.enQueue(20);
        queue.displayQueue();
    }
 }
