package Day8;

//Given a string S. The task is to print all permutations of a given string.
//Input: ABC
//Output:
//ABC ACB BAC BCA CAB CBA
//Explanation:
//Given string ABC has permutations in 6
//forms as ABC, ACB, BAC, BCA, CAB and CBA .
public class PermutationOfString {
    private static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n-1);
    }
}
