package Day54;

//Merge two sorted linked lists
public class MergeTwoSortedLists {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Method1: Iterative
    public Node sortedMerge(Node head1, Node head2) {
        Node result = new Node(0);
        Node temp = result;
        while(true) {
            if(head1 == null) {
                temp.next = head2;
                break;
            }
            if(head2 == null) {
                temp.next = head1;
                break;
            }
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        return result.next;
    }

    //Method2: Recursion: O(m+n): m and n are lengths of to linked lists
    public static Node sortedMergeUsingRecursion(Node head1, Node head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        if(head1.data <= head2.data) {
            head1.next = sortedMergeUsingRecursion(head1.next, head2);
            return head1;
        }
        else {
            head2.next = sortedMergeUsingRecursion(head1, head2.next);
            return head2;
        }
    }

    public static void printList(Node result) {
        Node temp = result;

        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);

        Node iterativeResult = new MergeTwoSortedLists().sortedMerge(head1, head2);
        printList(iterativeResult);

        //Node recursiveResult = sortedMergeUsingRecursion(head1, head2);
        //printList(recursiveResult);
    }
}
