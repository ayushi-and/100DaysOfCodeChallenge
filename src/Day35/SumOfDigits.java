package Day35;

// Java program to find sum of digits of a number until sum becomes single digit.
//Examples :
//Input : 1234
//Output : 1
//Explanation : The sum of 1+2+3+4 = 10,
//              digSum(x) == 10
//              Hence ans will be 1+0 = 1
//Input : 5674
//Output : 4
public class SumOfDigits {
    static int digSum(int n)
    {
        int sum = 0;
        while (n > 0 || sum > 9)
        {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static void main(String argc[])
    {
        int n = 1234;
        System.out.println(digSum(n));
    }
}
