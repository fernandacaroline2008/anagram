package com.viafoura.anagram.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordFunctionTest {

    @Test
    public void isAnagram_whenWordsAreEquals_shouldReturnTrue() {
        String word1 = "cinema";
        String word2 = "cinema";
        assertTrue(WordFunction.isAnagram(word1, word2));
    }

    @Test
    public void isAnagram_whenWordsAreAnagrams_shouldReturnTrue() {
        String word1, word2;

        word1 = "cinema";
        word2 = "iceman";
        assertTrue(WordFunction.isAnagram(word1, word2));

        word1 = "Listen";
        word2 = "Silent";
        assertTrue(WordFunction.isAnagram(word1, word2));

        word1 = "Funeral";
        word2 = "Real fun";
        assertTrue(WordFunction.isAnagram(word1, word2));
    }

    @Test
    public void isAnagram_whenWordsHaveDifferentLength_shouldReturnFalse() {
        String word1 = "save";
        String word2 = "car";
        assertFalse(WordFunction.isAnagram(word1, word2));
    }

    @Test
    public void isAnagram_whenWordsAreNotAnagrams_shouldReturnFalse() {
        String word1 = "car";
        String word2 = "art";
        assertFalse(WordFunction.isAnagram(word1, word2));
    }

    @Test
    public void getAnagrams_shouldReturnListOfAnagrams() {
        String word = "abc";
        Set<String> anagramsExpected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba"));

        Set<String> anagrams = WordFunction.getAnagrams(word);

        assertThat(anagrams, is(anagramsExpected));
    }
}