package com.viafoura.anagram.controller;

import com.google.gson.Gson;
import com.viafoura.anagram.dto.AnagramDto;
import com.viafoura.anagram.dto.AnagramListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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
    public void isAnagram_whenStringsAreAnagrams_returnSuccess() throws Exception {
        String uri = String.format("%s/%s/%s", ANAGRAM_URI, "cinema", "iceman");

        AnagramDto responseExpected = new AnagramDto(true);

        mockMvc.perform(get(uri))
               .andExpect(status().isOk())
               .andExpect(content().string(gson.toJson(responseExpected)));
    }

    @Test
    public void isAnagram_whenStringsAreNotAnagrams_returnSuccess() throws Exception {
        String uri = String.format("%s/%s/%s", ANAGRAM_URI, "car", "art");

        AnagramDto responseExpected = new AnagramDto(false);

        mockMvc.perform(get(uri))
               .andExpect(status().isOk())
               .andExpect(content().string(gson.toJson(responseExpected)));
    }

    @Test
    public void isAnagram_whenStringsAreNotValid_returnError() throws Exception {
        String uri = String.format("%s/%s/%s", ANAGRAM_URI, "cinema", "iceman4");

        mockMvc.perform(get(uri))
               .andExpect(status().isBadRequest());
    }

    @Test
    public void getAnagrams_whenStringIsValid_returnSuccess() throws Exception {
        String uri = String.format("%s/%s", ANAGRAM_URI, "abc");

        Set<String> anagrams = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba"));

        AnagramListDto responseExpected = new AnagramListDto(anagrams);

        MvcResult result = mockMvc.perform(get(uri))
                                  .andExpect(status().isOk()).andReturn();

        assertThat(gson.fromJson(result.getResponse().getContentAsString(), AnagramListDto.class), is(responseExpected));
    }

    @Test
    public void getAnagrams_whenStringIsNotValid_returnError() throws Exception {
        String uri = String.format("%s/%s", ANAGRAM_URI, "iceman4");

        mockMvc.perform(get(uri))
               .andExpect(status().isBadRequest());
    }
}