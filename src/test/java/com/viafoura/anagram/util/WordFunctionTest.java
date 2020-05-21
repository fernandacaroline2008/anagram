package com.viafoura.anagram.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordFunctionTest {

    @Test
    public void isAnagrams_whenWordsAreEquals_shouldReturnTrue() {
        String word1 = "cinema";
        String word2 = "cinema";
        assertTrue(WordFunction.isAnagrams(word1, word2));
    }

    @Test
    public void isAnagrams_whenWordsAreAnagrams_shouldReturnTrue() {
        String word1, word2;

        word1 = "cinema";
        word2 = "iceman";
        assertTrue(WordFunction.isAnagrams(word1, word2));

        word1 = "Listen";
        word2 = "Silent";
        assertTrue(WordFunction.isAnagrams(word1, word2));

        word1 = "Funeral";
        word2 = "Real fun";
        assertTrue(WordFunction.isAnagrams(word1, word2));
    }

    @Test
    public void isAnagrams_whenWordsHaveDifferentLength_shouldReturnFalse() {
        String word1 = "save";
        String word2 = "car";
        assertFalse(WordFunction.isAnagrams(word1, word2));
    }

    @Test
    public void isAnagrams_whenWordsAreNotAnagrams_shouldReturnFalse() {
        String word1 = "car";
        String word2 = "art";
        assertFalse(WordFunction.isAnagrams(word1, word2));
    }
}