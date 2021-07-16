package Day3;

//Given an array containing N positive integers and an integer K.
//Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.
//For Input:
//1
//7 5
//4 1 1 1 2 3 5
//your output is:
//4
//Variable size sliding window

public class LargestSubArray {
    static int lengthOfLongestSubArray(int arr[], int n, int k){
        int beg = 0;
        int end = 0;
        int sum = 0;
        int max_count = Integer.MIN_VALUE;

        while(end < n){
            sum = sum + arr[end];

            if(sum < k){
                end++;
            }
            else if(sum == k){
                int window_size = end - beg + 1;
                max_count = Math.max(max_count, window_size);
                end++;
            }
            else{
                while(sum > k) {
                    sum = sum - arr[beg];
                    beg++;
                }
                if(sum == k){  //This part is corner case; after decreasing the window, we might also encounter sum == k,
                    //hence add a check in third condition and this will work fine
                    max_count = Math.max(max_count, end-beg+1);
                }
                end++;
            }
        }
        return max_count;
    }
    public static void main(String[] args){
        int arr[] = { 4, 1, 1, 1, 2, 3, 5};
        System.out.println(lengthOfLongestSubArray(arr, arr.length, 5));
    }
}
