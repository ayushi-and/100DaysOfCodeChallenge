package Day46;

//We are given a stack data structure with push and pop operations,
//the task is to implement a queue using instances of stack data structure and operations on them.
//Queue can also be implemented using one user stack and one Function Call Stack.
//Time Complexity:
//Push operation : O(1).
//Same as pop operation in stack.
//Pop operation : O(N).
//The difference from above method is that in this method element is returned and all elements are restored back in a single call.
//Auxiliary Space: O(N).
//Use of stack for storing values.
import java.util.Stack;

//Method 3: Recursion (or Function Call Stack) is used to implement queue using only one user defined stack.
public class QueueUsingSingleStackMethod3 {

    Stack<Integer> stack = new Stack<>();

    private void enqueue(int i) {
        stack.push(i);
    }

    private int dequeue() throws Exception {
        if (stack.size() == 0)
            throw new Exception("Queue is Empty");

        if (stack.size() == 1)
            return stack.pop();

        int data = stack.pop();
        int retVal = dequeue();
        stack.push(data);
        return retVal;
    }

    public static void main(String[] args) throws Exception {
        QueueUsingSingleStackMethod3 queue = new QueueUsingSingleStackMethod3();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

}
