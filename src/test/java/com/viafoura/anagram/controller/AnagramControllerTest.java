package com.viafoura.anagram.controller;

import com.google.gson.Gson;
import com.viafoura.anagram.dto.AnagramDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnagramController.class)
public class AnagramControllerTest {

    private static final String ANAGRAM_URI = "/anagrams";
    private static final Gson gson = new Gson();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void isAnagrams_whenStringsAreAnagrams_returnSuccess() throws Exception {
        String uri = String.format("%s/%s/%s", ANAGRAM_URI, "cinema", "iceman");

        AnagramDto responseExpected = new AnagramDto(true);

        mockMvc.perform(get(uri))
               .andExpect(status().isOk())
               .andExpect(content().string(gson.toJson(responseExpected)));
    }

    @Test
    public void isAnagrams_whenStringsAreNotAnagrams_returnSuccess() throws Exception {
        String uri = String.format("%s/%s/%s", ANAGRAM_URI, "car", "art");

        AnagramDto responseExpected = new AnagramDto(false);

        mockMvc.perform(get(uri))
               .andExpect(status().isOk())
               .andExpect(content().string(gson.toJson(responseExpected)));
    }

    @Test
    public void isAnagrams_whenStringsAreNotValid_returnError() throws Exception {
        String uri = String.format("%s/%s/%s", ANAGRAM_URI, "cinema", "iceman4");

        mockMvc.perform(get(uri))
               .andExpect(status().isBadRequest());
    }

}