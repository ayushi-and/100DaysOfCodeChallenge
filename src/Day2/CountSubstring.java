package Day2;

import java.util.HashMap;
import java.util.Map;

//Given a string S consisting of N characters and a positive integer K,
//the task is to count the number of substrings having at least K distinct characters.
//Input: S = “abcca”, K = 3
//Output: 4
//Explanation:
//The substrings that contain at least K(= 3) distinct characters are:
//
//“abc”: Count of distinct characters = 3.
//“abcc”: Count of distinct characters = 3.
//“abcca”: Count of distinct characters = 3.
//“bcca”: Count of distinct characters = 3.
//Therefore, the total count of substrings is 4.
//
//Input: S = “abcca”, K = 4
//Output: 0
//USING SLIDING WINDOW TECHNIQUE
public class CountSubstring {
    static void atLeastKDistinctChars(String s, int k){
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        int beg = 0;
        int end = 0;
        int ans = 0;

        while(end < n) {
            char c = s.charAt(end);
            mp.put(c, mp.getOrDefault(c, 0) + 1);

            end++;

            while(mp.size() >= k){
                char pre = s.charAt(beg);
                mp.put(pre,mp.getOrDefault(pre,0)-1);

                if(mp.get(pre) == 0){
                    mp.remove(pre);
                }

                ans += s.length() - end + 1;
                beg++;
            }
        }
        System.out.println(ans);
    }

    public static void main (String[] args)
    {
        atLeastKDistinctChars("abcca", 3);
    }
}
