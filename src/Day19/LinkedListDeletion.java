package Day19;

//Deletion operation on LinkedList
//SinglyLinkedList
//Deletion By Key -> To be done: Given a ‘key’, delete the first occurrence of this key in the linked list.
//Deletion At Position -> To be done: Given a ‘position’, delete the node at this position from the linked list.
public class LinkedListDeletion {

    Node head;

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

    public static LinkedListDeletion insert(LinkedListDeletion list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if(list.head == null) {
            list.head = newNode;
        }
        else {
            Node last = list.head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void printList(LinkedListDeletion list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");
        while(currNode != null) {
            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }
    }
    // **************DELETION BY KEY**************

    public static LinkedListDeletion deleteByKey(LinkedListDeletion list, int key) {
        Node currNode = list.head;
        Node prev = null;

        // CASE 1: If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            System.out.println(key + " found and deleted");

            return list;
        }

        //CASE 2: If the key is somewhere other than at head
        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }

        //CASE 3: The key is not present
        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            System.out.println(key + " not found");
        }
        return list;
    }


    // ******DELETION AT POSITION******

    // Method to delete a node in the LinkedList by POSITION
    public static LinkedListDeletion deleteAtPosition(LinkedListDeletion list, int index) {
        Node currNode = list.head;
        Node prev = null;

        //CASE 1: If index is 0, then head node itself is to be deleted
        if(index == 0 && currNode != null) {
            list.head = currNode.next;
            System.out.println(index + " position element deleted");

            return list;
        }

        //CASE 2: If the index is greater than 0 but less than the size of LinkedList
        int counter = 0;
        //Count for the index to be deleted, keep track of the previous node as it is needed to change currNode.next
        while(currNode != null) {
            if(counter == index) {
                //Since the currNode is the required position Unlink currNode from linked list
                prev.next = currNode.next;

                System.out.println(index + " position element deleted");
                break;
            }
            else {
                // If current position is not the index
                // continue to next node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        // If the position element was found, it should be
        // at currNode Therefore the currNode shall not be null

        // CASE 3: The index is greater than the size of then LinkedList
        if (currNode == null) {
            System.out.println(index + " position element not found");
        }

        return list;
    }

    public static void main(String[] args) {

        LinkedListDeletion list = new LinkedListDeletion();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        printList(list);

        deleteByKey(list, 1);
        printList(list);

        deleteByKey(list, 8);
        printList(list);

        deleteByKey(list, 4);
        printList(list);

        deleteAtPosition(list, 0);
        printList(list);

        deleteAtPosition(list, 2);
        printList(list);

        deleteAtPosition(list, 10);
        printList(list);
    }
}