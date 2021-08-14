package Day31;

import java.util.Stack;

//Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.
//Using stack
public class IsListAPalindrome {
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
    }

    public boolean isPalindrome() {
        Node current = head;
        Stack<Integer> stack = new Stack<Integer>();
        boolean isPalindrome = true;

        while(current != null) {
            stack.push(current.data);
            current = current.next;
        }

        while(head != null) {
            int data = stack.pop();
            if(head.data == data) {
                isPalindrome = true;
            }
            else {
                isPalindrome = false;
                break;
            }
            head = head.next;
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        IsListAPalindrome list = new IsListAPalindrome();
        list.push(60);
        list.push(50);
        list.push(40);
        list.push(40);
        list.push(50);
        list.push(60);

        list.printList();
        System.out.println("\n" +list.isPalindrome());
    }
}
