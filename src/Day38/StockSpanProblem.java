package Day38;

import java.util.Arrays;

//The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and
//we need to calculate span of stock’s price for all n days.
//The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
//for which the price of the stock on the current day is less than or equal to its price on the given day.
//For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
//then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
//O(n^2) - Brute force
public class StockSpanProblem {
    static int[] calculateSpan(int[] arr, int n, int[] result) {
        result[0] = 1;
        for(int i = 1; i < n; i++) {
            result[i] = 1;
            for(int j = i-1; (j>=0) && (arr[j] <= arr[i]); j--) {
                result[i]++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int n = arr.length;
        int[] result = new int[n];
        System.out.println(Arrays.toString(calculateSpan(arr, n, result)));
    }
}
