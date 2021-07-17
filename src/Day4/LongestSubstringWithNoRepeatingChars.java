package Day4;

//find the longest substring of unique letters.
//For example, the longest substring of unique letters in “CODINGISAWESOME” is “NGISAWE”.
//Using Sliding Window

import java.util.HashSet;

public class LongestSubstringWithNoRepeatingChars {
    static Integer getUniqueCharacterSubstring(String input) {
        int maxLength = 0; // Maximum length of substring
        String output = ""; // Longest Substring With No Repeating Chars
        HashSet<Character> uniqueCharacters = new HashSet<>(); // This set will store the unique characters
        int start = 0; // Starting window index
        int end = 0; // Ending window index

        if (input == null || input.equals("")) {
            return 0;
        }

        while(end < input.length()){
            if(uniqueCharacters.add(input.charAt(end))){
                end++;
                maxLength = Math.max(maxLength, uniqueCharacters.size());
                if(output.length() < end - start + 1) {
                    output = input.substring(start, end);
                }
            }
            else{
                uniqueCharacters.remove(input.charAt(start));
                start++;
            }
        }
        System.out.println("Longest Substring With No Repeating Chars is " +output);
        return maxLength;
    }

    public static void main (String[] args)
    {
        System.out.println(getUniqueCharacterSubstring("CODINGISAWESOME"));
    }
}
