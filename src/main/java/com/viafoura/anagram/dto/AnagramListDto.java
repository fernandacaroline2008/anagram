package com.viafoura.anagram.dto;

import java.util.Set;

public class AnagramListDto {
    public final Set<String> anagrams;

    public AnagramListDto(Set<String> anagrams) {
        this.anagrams = anagrams;
    }
}
