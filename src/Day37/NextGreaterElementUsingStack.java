package Day37;

//Given an array arr[ ] of size N having distinct elements,
//the task is to find the next greater element for each element of the array in order of their appearance in the array.
//Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
//If there does not exist next greater of current element,
//then next greater element for current element is -1. For example, next greater of the last element is always -1.
//Example 1:
//Input:
//N = 4, arr[] = [1 3 2 4]
//Output:
//3 4 4 -1
//Explanation:
//In the array, the next larger element
//to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ?
//since it doesn't exist, it is -1.

//Time Complexity- O(n)
//Auxiliary Space- O(n)
public class NextGreaterElementUsingStack {
    static class stack {
        int top;
        int arr[] = new int[100];

        void push(int x) {
            if(top == 99) {
                System.out.println("Stack is full!");
            }
            else {
                arr[++top] = x;
            }
        }
        int pop() {
            if(top == -1) {
                System.out.println("Stack underflow!");
                return -1;
            }
            else {
                int x = arr[top--];
                return x;
            }
        }
        boolean isEmpty() {
            return (top == -1) ? true : false;
        }
    }
    //11, 13, 21, 3
    static void printNextGreaterElement(int[] arr, int n) {
        int i = 0;
        stack s = new stack();
        s.top = -1;
        int element;
        int next;
        s.push(arr[0]);

        for(i = 1; i < n; i++) {
            next = arr[i];

            if(s.isEmpty() == false) {
                element = s.pop();
                while(element < next) {
                    System.out.println(element + " -> " +next);
                    if(s.isEmpty() == true)
                        break;
                    element = s.pop();
                }
                if (element > next) {
                    s.push(element);
                }
            }
            s.push(next);
        }
        while (s.isEmpty() == false) {
            element = s.pop();
            next = -1;
            System.out.println(element + " -> " + next);
        }
    }

    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        printNextGreaterElement(arr, n);
    }
}
