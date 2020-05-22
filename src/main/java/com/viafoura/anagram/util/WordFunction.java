package com.viafoura.anagram.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordFunction {

    public static boolean isAnagram(String word1, String word2) {
        word1 = format(word1);
        word2 = format(word2);

        if (word1.length() != word2.length()) {
            return false;
        }

        if (word1.equals(word2)) {
            return true;
        }

        String word1Sorted = sort(word1);
        String word2Sorted = sort(word2);

        return word1Sorted.equals(word2Sorted);
    }

    public static Set<String> getAnagrams(String word) {
        word = format(word);

        Set<String> anagrams = new HashSet<>();
        permutation("", word, anagrams);

        return anagrams;
    }

    private static Set<String> permutation(String prefix, String string, Set<String> anagrams) {
        if (string.length() == 0) {
            anagrams.add(prefix);
            return anagrams;
        }

        for (int i = 0; i < string.length(); i++) {
            String newPrefix = prefix + string.charAt(i);
            String newString = string.substring(0, i) + string.substring(i + 1, string.length());

            permutation(newPrefix, newString, anagrams);
        }

        return anagrams;
    }

    private static String format(String word) {
        return word.replace(" ", "").toLowerCase();
    }

    private static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
