package com.viafoura.anagram.controller;

import com.viafoura.anagram.dto.AnagramDto;
import com.viafoura.anagram.dto.AnagramListDto;
import com.viafoura.anagram.util.WordFunction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/anagrams")
public class AnagramController {

    @GetMapping("{string1}/{string2}")
    public ResponseEntity<AnagramDto> isAnagrams(@PathVariable("string1") String string1, @PathVariable("string2") String string2) {
        if (!isStringValid(string1) || !isStringValid(string2)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        boolean isAnagram = WordFunction.isAnagram(string1, string2);

        return new ResponseEntity(new AnagramDto(isAnagram), HttpStatus.OK);
    }

    @GetMapping("{string1}")
    public ResponseEntity<AnagramListDto> getAnagrams(@PathVariable("string1") String string1) {
        if (!isStringValid(string1)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Set<String> anagrams = null;

        return new ResponseEntity(new AnagramListDto(anagrams), HttpStatus.OK);
    }

    private boolean isStringValid(String string) {
        return string.matches("[a-zA-Z]+");
    }
}
