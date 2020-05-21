package com.viafoura.anagram.util;

import java.util.Arrays;

public class WordFunction {

    public static boolean isAnagrams(String word1, String word2) {
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

    private static String format(String word) {
        return word.replace(" ", "").toLowerCase();
    }

    private static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
