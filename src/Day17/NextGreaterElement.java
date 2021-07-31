package Day17;

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

public class NextGreaterElement {

    static void printElement(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            int next = -1;
            for(int j = i+1; j < n; j++) {
                if(arr[j] > arr[i]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + " -> " +next);
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        int n = arr.length;
        printElement(arr, n);
    }
}
