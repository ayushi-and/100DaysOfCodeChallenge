package Day28;


//Given two Linked Lists, create union and intersection lists that contain union and intersection of the elements present in the given lists.
//Order of elements in output lists does not matter.
//Example:
//Input:
//   List1: 10->15->4->20
//   List2:  8->4->2->10
//Output:
//   Intersection List: 4->10
//   Union List: 2->8->20->4->15->10
//This method assumes that there are no duplicates in the given lists

//Time Complexity: O(m+n).
//Here ‘m’ and ‘n’ are number of elements present in first and second lists respectively.
//For union: Traverse both the lists, store the elements in Hash-map and update the respective count.
//For intersection: First traverse list-1, store its elements in Hash-map and then for every element in list-2 check if it is already present in the map.
//This takes O(1) time.
//Auxiliary Space:O(m+n).
//Use of Hash-map data structure for storing values.

import java.util.HashMap;
import java.util.HashSet;

// (Use Hashing)
public class UnionIntersectionOfListsHashing {
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
        Node tNode = head;
        while(tNode != null) {
            System.out.print(tNode.data+"->");
            tNode = tNode.next;
        }
        System.out.println("NULL");
    }
    UnionIntersectionOfListsHashing getUnion(Node head1, Node head2) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        Node n1 = head1;
        Node n2 = head2;
        UnionIntersectionOfListsHashing result = new UnionIntersectionOfListsHashing();
        while (n1 != null) {
            if(hmap.containsKey(n1.data)) {
                int value = hmap.get(n1.data);
                hmap.put(n1.data, value + 1);
            }
            else {
                hmap.put(n1.data, 1);
            }
            n1 = n1.next;
        }
        while (n2 != null) {
            if(hmap.containsKey(n2.data)) {
                int val = hmap.get(n2.data);
                hmap.put(n2.data, val + 1);
            }
            else {
                hmap.put(n2.data, 1);
            }
            n2 = n2.next;
        }
        for(int num : hmap.keySet()) {
            result.append(num);
        }

        return result;
    }

    public void append(int new_data) {
        if(head == null) {
            Node n = new Node(new_data);
            head = n;
            return;
        }
        Node n1 = head;
        Node n2 = new Node(new_data);
        while (n1.next != null) {
            n1 = n1.next;
        }
        n1.next = n2;
        n2.next = null;

    }

    UnionIntersectionOfListsHashing getIntersection(Node head1, Node head2) {
        HashSet<Integer> hset = new HashSet<>();
        Node n1 = head1;
        Node n2 = head2;
        UnionIntersectionOfListsHashing result = new UnionIntersectionOfListsHashing();

        // loop stores all the elements of list1 in hset
        while (n1 != null) {
            if(hset.contains(n1.data)) {
                hset.add(n1.data);
            }
            else {
                hset.add(n1.data);
            }
            n1 = n1.next;
        }
        while (n2 != null) {
            if(hset.contains(n2.data)) {
                result.push(n2.data);
            }
            n2 = n2.next;
        }
        return result;
    }

    public static void main(String[] args) {
        UnionIntersectionOfListsHashing list1 = new UnionIntersectionOfListsHashing();
        UnionIntersectionOfListsHashing list2 = new UnionIntersectionOfListsHashing();

        UnionIntersectionOfListsHashing unionList = new UnionIntersectionOfListsHashing();
        UnionIntersectionOfListsHashing intersectionList = new UnionIntersectionOfListsHashing();

        /*create a linked list 10->15->5->20 */
        list1.push(20);
        list1.push(4);
        list1.push(15);
        list1.push(10);

        /*create a linked list 8->4->2->10 */
        list2.push(10);
        list2.push(2);
        list2.push(4);
        list2.push(8);

        System.out.println("First List is");
        list1.printList();

        System.out.println("Second List is");
        list2.printList();

        unionList = unionList.getUnion(list1.head, list2.head);
        intersectionList = intersectionList.getIntersection(list1.head, list2.head);

        System.out.println("Union List is");
        unionList.printList();

        System.out.println("Intersection List is");
        intersectionList.printList();


    }
}
