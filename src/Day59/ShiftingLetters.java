package Day59;

/* ---Shifting Letters

You are given a string s of lowercase English letters and an integer array shifts of the same length.
Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.
Return the final string after all such shifts to s are applied.

Example 1:
Input: s = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: We start with "abc".
After shifting the first 1 letters of s by 3, we have "dbc".
After shifting the first 2 letters of s by 5, we have "igc".
After shifting the first 3 letters of s by 9, we have "rpl", the answer.

Example 2:
Input: s = "aaa", shifts = [1,2,3]
Output: "gfd"

Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
shifts.length == s.length
0 <= shifts[i] <= 109
 */

//Time Complexity - O(len(string))
public class ShiftingLetters {
    static String shiftingLetters(String s, int[] shifts) {
        //Used char array value can be changed in array since string is immutable.
        char[] str = s.toCharArray();
        int shift = 0;

        for(int i = str.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            str[i] = (char) ((str[i] - 'a' + shift) % 26 + 'a');
        }
        return new String(str);
    }

    public static void main(String[] args) {
        int[] shifts = {3,5,9};
        String s = "abc";
        System.out.println(shiftingLetters(s, shifts));
    }
}
