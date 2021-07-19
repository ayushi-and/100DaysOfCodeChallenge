package Day5;

import java.util.ArrayList;
import java.util.List;
//Anagram Substring Search (Or Search for all permutations)
//Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[]
//and its permutations (or anagrams) in txt[]. You may assume that n > m.
public class AnagramSubstringSearch {
    private static List<Integer> findIndices(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        List<Integer> indices = new ArrayList<>();
        int[] textCount = new int[256];
        int[] patternCount = new int[256];
        for (int i = 0; i < m; i++) {
            textCount[text.charAt(i)]++;
            patternCount[pattern.charAt(i)]++;
        }
        for (int i = m; i < n; i++) {
            if (isCountEqual(textCount, patternCount)) {
                indices.add(i - m);
            }
            textCount[text.charAt(i - m)]--;
            textCount[text.charAt(i)]++;
        }
        if (isCountEqual(textCount, patternCount)) {
            indices.add(n - m);
        }
        return indices;
    }

    private static boolean isCountEqual(int[] textCount, int[] patternCount) {
        for (int i = 0; i < 256; i++) {
            if (textCount[i] != patternCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "BACDGABCDA";
        String pattern = "ABCD";
        System.out.println("Anagrams are found at: " + findIndices(text, pattern));
    }
}
