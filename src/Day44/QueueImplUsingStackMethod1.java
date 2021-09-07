package Day44;

//We are given a stack data structure with push and pop operations,
//the task is to implement a queue using instances of stack data structure and operations on them.
//A queue can be implemented using two stacks.
//METHOD - 1 : By making enQueue operation costly : This method makes sure that oldest entered element is always at the top of stack 1,
//so that deQueue operation just pops from stack1. To put the element at top of stack1, stack2 is used.
//Time Complexity:
//Push operation: O(N).
//In the worst case we have empty whole of stack 1 into stack 2.
//Pop operation: O(1).
//Same as pop operation in stack.
//Auxiliary Space: O(N).
//Use of stack for storing values.

import java.util.Stack;

//METHOD - 1 : By making enQueue operation costly

public class QueueImplUsingStackMethod1 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enQueue(int key) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(key);

        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int deQueue() {
        if(s1.isEmpty()) {
            System.out.println("Queue is Empty");
            System.exit(0);
        }
        int x = s1.peek();
        s1.pop();
        return x;
    }

    public static void main(String[] args) {
        QueueImplUsingStackMethod1 q = new QueueImplUsingStackMethod1();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }

}
