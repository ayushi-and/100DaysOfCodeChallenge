package Day26;

//Write a function detectAndRemoveLoop() that checks whether a given Linked List contains loop and
//if loop is present then removes the loop and returns true. If the list does not contain loop then it returns false.

//To remove loop, all we need to do is to get pointer to the last node of the loop.
//For example, node with value 5 in the above diagram. Once we have pointer to the last node, we can make the next of this node as NULL and loop is gone.
//We can easily use Hashing or Visited node techniques (discussed in the above mentioned post) to get the pointer to the last node.
//Idea is simple: the very first node whose next is already visited (or hashed) is the last node.

//Example 1
//Input:   1 -> 2 -> 3 -> 4 -> 5
//                   |         |
//                   |         |
//                   - - - - - -
//Output:  1 -> 2 -> 3 -> 4 -> 5
//Explanation: The node 5 at the end of loop points to 3 and creates a loop. We make it point to NULL and remove the loop.

//Example 2
//Input: 2 -> 20 -> 6 -> 19 -> 13 -> 4
//Output: 2 -> 20 -> 6 -> 19 -> 13 -> 4
//Explanation: No loop present.

//he Floyd's algorithm will be used to detect and remove the loop from the linked list.
public class DetectAndRemoveLoopInList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void printList() {
        Node tNode = head;
        while(tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
    }

    public int detectAndRemoveLoop(DetectAndRemoveLoopInList list) {
        Node slowPtr = list.head;
        Node fastPtr = list.head;

        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                removeLoop(slowPtr, list.head);
                return 1;
            }
        }
        return 0;
    }

    public void removeLoop(Node slowPtr, Node head) {
        Node p1 = slowPtr;
        Node p2 = head;

        while(p1.next != p2.next) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = null;
    }

    public static void main(String[] args) {
        DetectAndRemoveLoopInList list = new DetectAndRemoveLoopInList();
        /*list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);*/

        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;
        list.detectAndRemoveLoop(list);
        System.out.println("Linked List after removing loop : ");
        list.printList();
    }

}
