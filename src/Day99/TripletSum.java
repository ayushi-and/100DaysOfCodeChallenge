package Day99;

import java.util.Arrays;

/*
Given an array and a value, find if there is a triplet in array whose sum is equal to the given value.
If there is such a triplet present in array, then print the triplet and return true. Else return false
Input:array = {12, 3, 4, 1, 6, 9}, sum = 24;
Output:12, 3, 9
Explanation:There is a triplet (12, 3 and 9) present
in the array whose sum is 24
 */
public class TripletSum {
    static void findTriplet(int[] arr, int k) {
        Arrays.sort(arr); //1, 3, 4, 6, 9, 12, 8, 8, 8
        int sum = 0;
        for(int i = 0; i< arr.length; i++) {
            int start = i+1;
            int end = arr.length - 1;

            while(start < end) {
                sum = arr[i] + arr[start] + arr[end];

                if(sum == k) {
                    System.out.print(arr[i] + " " + arr[start] + " " + arr[end]);
                    start++;
                    end--;
                }
                else if(sum < k) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 1, 6, 9, 8, 8, 8};
        int sum = 24;
        findTriplet(arr, sum);
    }
}
