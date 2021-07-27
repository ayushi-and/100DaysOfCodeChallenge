package Day13;

import java.util.Arrays;

//Find all prime numbers smaller than or equal to a given number.
//Time Complexity: O(n*log(log(n)))
public class SieveOfEratosthenes {
    static void sieve(int n)
    {
        if(n <= 1)
            return;

        boolean isPrime[] = new boolean[n+1];

        Arrays.fill(isPrime, true);

        for(int i=2; i*i <= n; i++)
        {
            if(isPrime[i])
            {
                for(int j = 2*i; j <= n; j = j+i) //2*i == i*i to reduce iterations
                {
                    isPrime[j] = false;
                }
            }
        }

        for(int i = 2; i<=n; i++)
        {
            if(isPrime[i])
                System.out.print(i+" ");
        }
    }

    public static void main (String[] args) {

        int n = 18;

        sieve(n);

    }
}
