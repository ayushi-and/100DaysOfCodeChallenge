package Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

////Write a program to determine whether a number N is equal to the sum of its proper positive divisors (excluding the number itself)
////Input:
////First line: T (number of test case)
////For each test case
////First line : N
////Output:
////Print YES if true else NO
////6 : YES (1+2+3)
////5 : NO (5 != 1)
////28: YES (1 + 2 + 4 + 7 + 14)
public class Perfection {
    static String Solve(int n){
        // Write your code here
        int sum = 0;
        for(int i = 1; i*i < n; i++) {
            if(n % i == 0) {
                sum = sum + i;
            }
        }
        for(int i = (int)Math.sqrt(n); i > 1; i--) {
            if(n % i == 0) {
                sum = sum + (n/i);
            }
        }

        if(sum == n) {
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());

            String out_ = Solve(N);
            System.out.println(out_);
        }
        wr.close();
        br.close();
    }
}
