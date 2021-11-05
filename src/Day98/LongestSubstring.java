package Day98;

import java.util.HashMap;
import java.util.Map;

/*
Question: Java program to find the longest substring with k unique characters in a given string
String s = "baacbebebe";
int k = 3;
O/P- cbebebe

 */
public class LongestSubstring {
    static void kDistinctChars(String s, int k){
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        int beg = 0;
        int end = 0;
        String output = "";

        while(end < n) { //baacbebebe, k = 3
            char c = s.charAt(end);
            mp.put(c, mp.getOrDefault(c, 0) + 1);

            end++;

            if(mp.size() == k) {
                if (output.length() < end - beg + 1) {
                    output = s.substring(beg, end);
                }
            }
            while(mp.size() > k){
                char pre = s.charAt(beg);
                mp.put(pre,mp.getOrDefault(pre,0)-1);

                if(mp.get(pre) == 0){
                    mp.remove(pre);
                }
                beg++;
            }

        }
        System.out.println(output);
    }

    public static void main(String[] ar) {
        kDistinctChars("baacbebebe", 3);
    }
}
