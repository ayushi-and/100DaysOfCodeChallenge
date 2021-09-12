package Day49;

import java.util.LinkedList;
import java.util.Queue;


//Method 3: Stack implementation using a single Queue
//SC and TC: O(n) :
public class StackUsingSingleQueueMethod3 {
    Queue<Integer> queue = new LinkedList<>();

    void push(int key) {
        queue.add(key);

        for(int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    int pop() {
        if(queue.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }

        int temp = queue.remove();

        return temp;
    }

    public static void main(String[] args) {
        StackUsingSingleQueueMethod3 s = new StackUsingSingleQueueMethod3();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
