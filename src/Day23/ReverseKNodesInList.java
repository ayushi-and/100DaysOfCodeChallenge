package Day23;

//Reverse a Linked List in groups of given size.
//Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.
//Example 1:
//Input:
//LinkedList: 1->2->2->4->5->6->7->8
//K = 4
//Output: 4 2 2 1 8 7 6 5
//Explanation:
//The first 4 elements 1,2,2,4 are reversed first and then the next 4 elements 5,6,7,8. Hence, the resultant linked list is 4->2->2->1->8->7->6->5.

//Example 2:
//Input:
//LinkedList: 1->2->3->4->5
//K = 3
//Output: 3 2 1 5 4
//Explanation:
//The first 3 elements are 1,2,3 are reversed first and then elements 4,5 are reversed.Hence, the resultant linked list is 3->2->1->5->4.

import java.util.Stack;

//Using Stack
public class ReverseKNodesInList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node tnode = head;
        while(tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    public void reverseKNodes(int k) {
        Node currNode = head;
        Node prev = null;
        Stack<Node> stack = new Stack<>();

        while(currNode != null) {
            int count = 0;
            while (currNode != null && count < k) {
                stack.push(currNode);
                currNode = currNode.next;
                count++;
            }
            while (stack.size() > 0) {
                if(prev == null) {
                    prev = stack.peek();
                    head = prev;
                }
                else {
                    prev.next = stack.peek();
                    prev = prev.next;
                }
                stack.pop();
            }
        }
        prev.next = null;
    }



    public static void main(String[] args) {
        ReverseKNodesInList list = new ReverseKNodesInList();

        list.push(10);
        list.push(11);
        list.push(30);
        list.push(20);
        list.push(12);
        list.push(5);

        System.out.println("Given Linked List");
        list.printList();
        list.reverseKNodes(3);

        System.out.println("Reversed list");
        list.printList();
    }

}
