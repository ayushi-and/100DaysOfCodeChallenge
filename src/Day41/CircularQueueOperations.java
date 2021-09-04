package Day41;

public class CircularQueueOperations {
    int front, rear;
    int max = 5;
    int[] arr = new int[max];

    CircularQueueOperations() {
        front = -1;
        rear = -1;
    }

    // check if the queue is full
    boolean isQueueFull() {
        if((front == 0 && rear == max - 1) || (front == rear + 1)) { //(REAR+1)%MAX = FRONT
            return true;
        }
        return false;
    }

    // check if the queue is empty
    boolean isQueueEmpty() {
        if(front == -1 && rear == -1) {
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
            if(front == -1 && rear == -1) {
                front = 0;
                rear = 0;
            }
            else if (front != 0 && rear == max - 1) {
                rear = 0;
            }
            else {
                rear = (rear + 1) % max;
            }
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
            else if(front == max - 1) {
                front = 0;
            }
            else {
                front++; //front=(front+1)%max;
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
        CircularQueueOperations queue = new CircularQueueOperations();
        queue.deQueue();
        for(int i = 1; i < 6; i ++) {
            queue.enQueue(i);
        }
        queue.enQueue(6);
        queue.displayQueue();
        queue.deQueue();
        queue.enQueue(8);
        queue.displayQueue();
    }
}
