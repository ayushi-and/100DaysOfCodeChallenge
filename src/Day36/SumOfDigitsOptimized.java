package Day36;

// Java program to find sum of digits of a number until sum becomes single digit.
//Examples :
//Input : 1234
//Output : 1
//Explanation : The sum of 1+2+3+4 = 10,
//              digSum(x) == 10
//              Hence ans will be 1+0 = 1
//Input : 5674
//Output : 4
//simple and elegant O(1) solution
//If n == 0, return 0;
//If n % 9 == 0
//    digSum(n) = 9
//Else
//    digSum(n) = n % 9
//A number can be of the form 9x or 9x + k. For the first case, answer is always 9. For the second case, and is always k.
public class SumOfDigitsOptimized {
    static int digSum(int n)
    {
        if (n == 0)
            return 0;
        return (n % 9 == 0) ? 9 : (n % 9);
    }
    public static void main (String[] args)
    {
        int n = 9999;
        System.out.println(digSum(n));
    }
}
