package Day12;

//Given a positive integer value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.
//Input:
//N = 10
//Output: 2
//Explanation: 4 and 9 have 3 divisors.
public class ExactlyThreeDivisors {
    public static int exactly3Divisors(int n)
    {
        int count = 0;
        for(int i = 2; i*i <= n; i++){
            if(isPrime(i)){
                if(i * i <= n){
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean isPrime(int n){
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        System.out.println(exactly3Divisors(10));
    }
}
