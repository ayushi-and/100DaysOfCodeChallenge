package Day45;

//We are given a stack data structure with push and pop operations,
//the task is to implement a queue using instances of stack data structure and operations on them.
//A queue can be implemented using two stacks.
//Method 2 (By making deQueue operation costly): In this method, in en-queue operation, the new element is entered at the top of stack1.
//In de-queue operation, if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.
//Time Complexity:
//Push operation: O(1).
//Same as pop operation in stack.
//Pop operation: O(N).
//In the worst case we have empty whole of stack 1 into stack 2
//Auxiliary Space: O(N).
//Use of stack for storing values.

import java.util.Stack;

//Method 2 (By making deQueue operation costly): More efficient
public class QueueImplUsingStackMethod2 {
    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void enQueue(int key) {
            s1.push(key);
        }

        int deQueue() {
            if(s1.isEmpty() && s2.isEmpty()) {
                System.out.println("Queue is empty");
                System.exit(0);
            }
            if(s2.isEmpty()) {
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            int x = s2.pop();
            return x;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }

}
