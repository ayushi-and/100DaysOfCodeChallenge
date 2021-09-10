package Day47;

//Implement Stack using Queues
//We are given a Queue data structure that supports standard operations like enqueue() and dequeue().
//We need to implement a Stack data structure using only instances of Queue and queue operations allowed on the instances.
//A stack can be implemented using two queues.


import java.util.LinkedList;
import java.util.Queue;

//Method 1 (By making push operation costly)
/*
-----------------Steps-----------------
PUSH(x): O(n)
1. Add x -> Queue2
2. Queue1 -> Queue2(element by element)
3. Swap (Queue1, Queue2)
POP(): O(1)
Remove the top of Queue1
 */
public class StackImplUsingQueueMethod1 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    void push(int key) {
        queue2.add(key);

        while(!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        Queue<Integer> queue = queue1;
        queue1 = queue2;
        queue2 = queue;

    }

    void pop() {
        if(queue1.isEmpty()) {
            System.out.println("Empty!");
            System.exit(0);
        }
        queue1.remove();
    }

    int top()
    {
        if (queue1.isEmpty())
            return -1;
        return queue1.peek();
    }

    public static void main(String[] args) {
        StackImplUsingQueueMethod1 s = new StackImplUsingQueueMethod1();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

    }
}
