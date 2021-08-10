package Day27;

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

//Time Complexity: O(m*n).
//Here ‘m’ and ‘n’ are number of elements present in first and second lists respectively.
//For union: For every element in list-2 we check if that element is already present in the resultant list made using list-1.
//For intersection: For every element in list-1 we check if that element is also present in list-2.
//Auxiliary Space: O(1).
//No use of any data structure for storing values.
public class UnionIntersectionOfLists {
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

    //Initialize the result list as NULL. Traverse list1 and add all of its elements to the result.
    //Traverse list2. If an element of list2 is already present in result then do not insert it to result, otherwise insert.
    void getUnion(Node head1, Node head2) {
        Node t1 = head1;
        Node t2 = head2;
        while (t1 != null) {
            push(t1.data);
            t1 = t1.next;
        }
        while (t2 != null) {
            if(!isPresent(head, t2.data))
                push(t2.data);
                t2 = t2.next;
        }
    }

    //Initialize the result list as NULL.
    //Traverse list1 and look for its every element in list2, if the element is present in list2, then add the element to result.
    void getIntersection(Node head1, Node head2) {
        Node t1 = head1;
        while(t1 != null) {
            if(isPresent(head2, t1.data))
                push(t1.data);
            t1 = t1.next;
        }
    }

    boolean isPresent(Node head, int data) {
        Node t = head;
        while (t != null) {
            if(t.data == data)
                return true;
            t = t.next;
        }
        return false;
    }

    public static void main(String[] args) {
        UnionIntersectionOfLists list1 = new UnionIntersectionOfLists();
        UnionIntersectionOfLists list2 = new UnionIntersectionOfLists();

        UnionIntersectionOfLists unionList = new UnionIntersectionOfLists();
        UnionIntersectionOfLists intersectionList = new UnionIntersectionOfLists();

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

        unionList.getUnion(list1.head, list2.head);
        intersectionList.getIntersection(list1.head, list2.head);

        System.out.println("Union List is");
        unionList.printList();

        System.out.println("Intersection List is");
        intersectionList.printList();


    }

}
