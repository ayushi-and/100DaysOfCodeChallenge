package Day66;

//Clone a linked list with next and random pointer in O(1) space
//Given a linked list having two pointers in each node. The first one points to the next node of the list,
//however, the other pointer is random and can point to any node of the list. Write a program that clones the given list in O(1) space,
//i.e., without any extra space.
//Time complexity : O(n)
//Auxiliary space : O(1)
public class CopyListWithRandomPointersNoExtraSpace {
    static class Node {
        int data;
        Node next;
        Node random;

        Node(int d) {
            data = d;
            next = null;
            random = null;
        }
    }

    static Node copiedList(Node head) {
        copyRandomList(head);
        copyRandomPointers(head);
        Node result = extractClonedList(head);
        return result;
    }

    //Create the copy of node 1 and insert it between node 1 & node 2 in the original Linked List,
    //create a copy of 2 and insert it between 2 & 3. Continue in this fashion, add the copy of N after the Nth node.
    static void copyRandomList(Node head) {
        Node current = head;
        while(current != null) {
            Node forwardNode = current.next;

            Node newNode = new Node(current.data); //Copy the data of original list one by one and insert it between nodes in original list respectively.
            current.next = newNode;
            newNode.next = forwardNode;

            current = forwardNode;
        }
    }

    //Now connect the random pointers of copied elements
    static void copyRandomPointers(Node head) {
        Node current = head;
        while(current != null) {
            Node random = current.random;
            current.next.random = random != null ? random.next : null; //main logic

            current = current.next.next; //since one copied node is also there between two nodes of original list
        }
    }

    //Now we have everything in a single list, we have to extract deep copy of list; cloned list from the resulted list.
    static Node extractClonedList(Node head) {
        Node copiedList = new Node(-1);
        Node prev = copiedList;
        Node current = head;
        while(current != null) {
            prev.next = current.next;
            current.next = current.next.next;

            prev = prev.next;
            current = current.next;
        }
        copiedList = copiedList.next;
        return copiedList;
    }

    static void printList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        //For next links
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        //For random links
        head.random = head;
        head.next.random = head.next.next.next.next;
        head.next.next.random = head;
        head.next.next.next.random = head.next;
        head.next.next.next.next.random = null;

        System.out.println("Original list is : ");
        printList(head);

        Node result = copiedList(head);
        System.out.println("\nCloned list is : ");
        printList(result);

    }
}
