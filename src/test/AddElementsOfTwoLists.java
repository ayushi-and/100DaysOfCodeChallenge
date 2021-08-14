package test;

public class AddElementsOfTwoLists {
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

    static Node newNode(int data)
    {
        Node new_node = new Node(data);
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }

    public void addLists(Node head1, Node head2) {
        int count1 = 0;
        int count2 = 0;
        int diff = 0;
        Node current1 = head1;
        Node current2 = head2;
        Node result = null;
        while(current1 != null) {
            count1++;
            current1 = current1.next;
        }
        while(current2 != null) {
            count2++;
            current2 = current2.next;
        }
        if(count2 > count1) {
            diff = count2 - count1;
            appendZeroes(diff, head1);
        }
        else {
            diff = count1 - count2;
            appendZeroes(diff, head2);
        }

        head1 = reverse(head1);
        head2 = reverse(head2);

        Node node1 = head1;
        Node node2 = head2;
        int carry = 0;

        while(node1.next != null && node2.next != null) {
            int addition = node1.data + node2.data + carry;
            int quotient = addition / 10;
            if(quotient == 0) {
                result = newNode(addition);
            }
            else {
                int remainder = addition % 10;
                result = newNode(remainder);
                carry = quotient;
            }
            result = result.next;
        }

    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node currNode = head;
        Node next = null;
        while(currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }
        return prev;
    }

    public static void appendZeroes(int count, Node head) {
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        for(int i = 0; i < count; i++) {
            current.next.data = 0;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        AddElementsOfTwoLists list1 = new AddElementsOfTwoLists();
        AddElementsOfTwoLists list2 = new AddElementsOfTwoLists();

        AddElementsOfTwoLists result = new AddElementsOfTwoLists();

        list1.push(4);
        list1.push(9);
        list1.push(2);
        list1.push(8);

        list2.push(1);
        list2.push(2);
        list2.push(4);
        list2.push(2);

        list1.printList();
        System.out.println();
        list2.printList();
        result.addLists(list1.head, list2.head);
        System.out.println();
        result.printList();
    }
}
