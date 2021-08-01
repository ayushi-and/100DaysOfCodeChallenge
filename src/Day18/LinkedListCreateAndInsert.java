package Day18;

//Creation, Insertion, Traversal and Printing of LinkedList
//SinglyLinkedList

public class LinkedListCreateAndInsert {

    Node head; //Head of list

    /* Linked list Node*/
    // This inner class is made static
    // so that main() can access it
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) {
            data = d;
            next = null;
        }
    }
    // **************INSERTION**************
    // Method to insert a new node
    public static LinkedListCreateAndInsert insert(LinkedListCreateAndInsert list, int data) {
        // Create a new node with given data
        Node newNode = new Node(data);
        newNode.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if(list.head == null) {
            list.head = newNode;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while(last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = newNode;
        }
        // Return the list by head
        return list;
    }

    // **************TRAVERSAL**************

    // Method to print the LinkedList.
    public static void printList(LinkedListCreateAndInsert list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while(currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            //Go to next node
            currNode = currNode.next;
        }
    }

    // method to create a Singly linked list with n nodes
    public static void main(String[] args) {

        /* Start with the empty list. */
        LinkedListCreateAndInsert list = new LinkedListCreateAndInsert();

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        printList(list);

    }
}
