package Day33;

//Implement basic stack operations in java (using linkedList)
//Pros: The linked list implementation of stack can grow and shrink according to the needs at runtime.
//Cons: Requires extra memory due to involvement of pointers.

public class ImplementStackUsingLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }
        else {
            Node currentNode = head;
            head = newNode;
            newNode.next = currentNode;
        }
        System.out.println(data + " pushed to stack");
    }

    int pop() {
        int x = Integer.MIN_VALUE;
        if(head == null) {
            System.out.println("Stack is Empty");
        }
        else {
            x = head.data;
            head = head.next;
        }
        return x;
    }

    int peek() {
        int x = Integer.MIN_VALUE;
        if(head == null) {
            System.out.println("Stack is empty");
        }
        else {
            x = head.data;
        }
        return x;
    }

    public static void main(String arr[]) {
        ImplementStackUsingLinkedList stack = new ImplementStackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Top most element is " +stack.peek());

        System.out.println(stack.pop() + " popped from stack.");

        System.out.println("Top most element is " +stack.peek());
    }
}
