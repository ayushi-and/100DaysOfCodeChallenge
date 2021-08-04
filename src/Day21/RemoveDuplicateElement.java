package Day21;

//Remove duplicate element from sorted as well as unsorted Linked List
//Given a singly linked list consisting of N nodes. The task is to remove duplicates (nodes with duplicate values) from the given list (if exists).
//Note: Try not to use extra space. Expected time complexity is O(N). The nodes are arranged in a sorted way.

import java.util.HashSet;

public class RemoveDuplicateElement {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Remove duplicate element from sorted Linked List
    static void removeDuplicatesFromSortedList(RemoveDuplicateElement list) {
        Node currNode = list.head;
        Node prev = list.head;

        /*while (currNode.next != null && currNode.next.next != null) {
            if (currNode.data == currNode.next.data) {
                currNode.next = currNode.next.next;
            }
            currNode = currNode.next;
        }
        if(currNode.next != null && currNode.data == currNode.next.data) {
            currNode.next = null;
        }*/

        while(currNode != null) {
            //Compare values of both pointers
            if(currNode.data != prev.data) { //1 2 3 4 5
                /* if the value of prev is not equal to the value of currNode that means there are no more occurrences of the prev data.
                So we can set the next of prev to the temp node.*/
                prev.next = currNode;
                prev = currNode;
            }
            //Set the temp to the next node
            currNode = currNode.next;
        }
        //This is the edge case if there are more than one occurrences of the last element
        if(prev != currNode){
            prev.next=null;
        }
    }

    // Function to remove duplicates from an unsorted linked list
    static void removeDuplicatesFromUnsortedList(RemoveDuplicateElement list) {
        Node currNode = list.head;
        Node prev = null;
        HashSet<Integer> hs = new HashSet<>();
        while(currNode  != null) {
            if (hs.contains(currNode.data)) {
                prev.next = currNode.next;
            }
            else {
                hs.add(currNode.data);
                prev = currNode;
            }
            currNode = currNode.next;
        }

    }


    public static void printList(RemoveDuplicateElement list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }
    }

    public static RemoveDuplicateElement insert(RemoveDuplicateElement list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void main(String[] args) {

        RemoveDuplicateElement list = new RemoveDuplicateElement();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 7);
        list = insert(list, 7);

        printList(list);
        removeDuplicatesFromSortedList(list);
        //removeDuplicatesFromUnsortedList(list);
        printList(list);

    }
}
