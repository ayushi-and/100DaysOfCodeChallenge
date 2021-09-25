package Day62;

//Given two numbers represented by two lists,
//write a function that returns the sum list. The sum list is a list representation of the addition of two input numbers.
//Input:
//List1: 5->6->3 // represents number 563
//List2: 8->4->2 // represents number 842
//Output:
//Resultant list: 1->4->0->5 // represents number 1405
//Explanation: 563 + 842 = 1405
public class AddTwoNumbersLists {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static void printList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(" " +current.data);
            current = current.next;
        }
    }

    static Node addTwoLists(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node node1 = getReverse(head1);
        Node node2 = getReverse(head2);

        int sum = 0;
        int carry = 0;
        Node temp = null;
        Node prev = null;
        Node result = null;

        while (node1 != null || node2 != null) {
            sum = carry + (node1 != null ? node1.data : 0) + (node2 != null ? node2.data : 0);

            carry = (sum >= 10) ? 1 : 0;

            sum = sum % 10;

            temp = new Node(sum);
            if (result == null) {
                result = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;

            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        if(carry > 0) {
            temp.next = new Node(carry);
        }

        Node reversedList = getReverse(result);
        return reversedList;
    }

    static Node getReverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(5);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);

        System.out.println("First List is ");
        printList(head1);

        Node head2 = new Node(8);
        head2.next = new Node(4);

        System.out.println("\nSecond List is ");
        printList(head2);

        Node resultantList = addTwoLists(head1, head2);

        System.out.println("\nResultant List is ");
        printList(resultantList);
    }
}
