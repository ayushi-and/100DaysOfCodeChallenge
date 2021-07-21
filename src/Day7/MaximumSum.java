package Day7;
//Window Sliding Technique Basic
//Given an array of integers of size ‘n’.
//Our aim is to calculate the maximum sum of ‘k’
//consecutive elements in the array.
//Input  : arr[] = {100, 200, 300, 400}
//         k = 2
//Output : 700
//Optimized : Sliding window
//Fixed size sliding window
public class MaximumSum {
    static int maxSum(int arr[], int n, int k){

        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        int beg = 0;
        int end = 0;
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;

        while(end < n){
            sum += arr[end];

            if(end - beg + 1 < k){ //window size is end-beg+1 always
                end++;
            }
            else if(end - beg + 1 == k){
                max_sum = Math.max(sum, max_sum);
                sum = sum - arr[beg];
                beg++;
                end++;
            }
        }

        return max_sum;
    }

    public static void main(String[] args){
        int arr[] = { 100, 200, 300, 400};
        System.out.println(maxSum(arr, arr.length, 2));
    }
}
