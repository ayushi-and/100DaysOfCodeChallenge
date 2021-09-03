package Day40;

//Basic operations of Queue using array - enqueue, dequeue, display, isEmpty, isFull.
public class QueueOperationsUsingArray {
    int front, rear;
    int max = 5;
    int[] arr = new int[max];

    QueueOperationsUsingArray() {
        front = -1;
        rear = -1;
    }

    // check if the queue is full
    boolean isQueueFull() {
        if(front == 0 && rear == max - 1) {
            return true;
        }
        return false;
    }

    // check if the queue is empty
    boolean isQueueEmpty() {
        if(front == -1) {
            return true;
        }
        else {
            return false;
        }
    }

    // insert elements to the queue
    void enQueue(int key) {
        if(isQueueFull()) {
            System.out.println("Queue is full");
        }
        else {
            if(front == -1) {
                front = 0;
            }
            rear++;
            arr[rear] = key;
            System.out.println(key + " Inserted");
        }
    }

    // delete element from the queue
    int deQueue() {
        int key;
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        }
        else {
            key = arr[front];
            if(front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front++;
            }
            System.out.println(key + " Deleted");
            return (key);
        }
    }

    // display element of the queue
    void displayQueue() {
        if(isQueueEmpty()) {
            System.out.println("Empty Queue");
        }
        else {
            System.out.println("Front index of queue -> " + front);
            for(int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " " + "\n");
            }
            System.out.println("Rear index of queue -> " + rear);
        }
    }

    public static void main(String[] args) {
        QueueOperationsUsingArray queue = new QueueOperationsUsingArray();
        queue.deQueue();
        for(int i = 1; i < 6; i ++) {
            queue.enQueue(i);
        }
        queue.enQueue(6);
        queue.displayQueue();
    }
}
