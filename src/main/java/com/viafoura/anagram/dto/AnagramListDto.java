package com.viafoura.anagram.dto;

import java.util.Objects;
import java.util.Set;

public class AnagramListDto {
    public final Set<String> anagrams;

    public AnagramListDto(Set<String> anagrams) {
        this.anagrams = anagrams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnagramListDto that = (AnagramListDto) o;
        return Objects.equals(anagrams, that.anagrams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anagrams);
    }
}
