package Day6;

//Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ]
//where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards.
//More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).
//Input:
//S = "aaaabbaa"
//Output: aabbaa
//Explanation: The longest Palindromic
//substring is "aabbaa"
public class LongestPalindromeInString {
    static int longestPalSubstr(String str)
    {
        int maxLength = 1;
        int start = 0;
        int len = str.length();
        int low, high;
        if(str.isEmpty()) {
            return 0;
        }
        if(str.length() == 1) {
            return 1;
        }
        for (int i = 1; i < len; ++i) {
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low)
                    == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low)
                    == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);

        return maxLength;
    }
    static void printSubStr(String str,
                            int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }
    public static void main(String[] args) {
        System.out.println("Length is: " + longestPalSubstr("forgeeksskeegfor"));
    }
}
