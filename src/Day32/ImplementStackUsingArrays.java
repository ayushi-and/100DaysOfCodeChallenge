package Day32;

//Implement basic stack operations in java (using arrays)

public class ImplementStackUsingArrays {
    static final int MAX = 1000;
    int top = -1;
    int arr[] = new int[MAX];

    public void push(int x) {
        if(top >= MAX - 1) {
            System.out.println("Stack Overflow!");
        }
        else {
            top++;
            arr[top] = x; //arr[++top] = x
            System.out.println(x + " pushed into stack");
        }
    }

    int pop() {
        if(top <= -1) {
            System.out.println("Stack Underflow!");
            return 0;
        }
        else {
           int x = arr[top]; //int x = arr[top--]
           top--;
           return x;
        }
    }

    int peek() {
        if(top <= -1) {
            System.out.println("Stack Underflow!");
            return 0;
        }
        else {
            int x = arr[top];
            return x;
        }
    }

    public static void main(String arr[]) {
        ImplementStackUsingArrays stack = new ImplementStackUsingArrays();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Top most element is " +stack.peek());

        System.out.println(stack.pop() + " popped from stack.");

        System.out.println("Top most element is " +stack.peek());
    }
}
