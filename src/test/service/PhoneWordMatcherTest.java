package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.PhoneWordMatcher;
import model.PhoneWord;

import static org.junit.jupiter.api.Assertions.*;

class PhoneWordMatcherTest {

    private Map<String, String> dictionary;
    private List<String> phoneNumbers;

    @BeforeEach
    public void setUp() {
        dictionary = new HashMap<>();
        dictionary.put("KITTY", "54889");
        dictionary.put("STAR", "7827");
        dictionary.put("WARS", "9277");

        phoneNumbers = new ArrayList<>();
        phoneNumbers.add("54889");
        phoneNumbers.add("782792771");
    }

    @Test
    public void testGetPhoneWords() {
        PhoneWordMatcher phoneWordMatcher = new PhoneWordMatcher(dictionary, phoneNumbers);
        List<PhoneWord> phoneWords = phoneWordMatcher.getPhoneWords();

        assertEquals(2, phoneWords.size());

        PhoneWord phoneWord1 = phoneWords.get(0);
        assertEquals("54889", phoneWord1.getPhoneNumber());
        assertEquals(1, phoneWord1.getPhoneWords().size());
        assertEquals("KITTY", phoneWord1.getPhoneWords().get(0));

        PhoneWord phoneWord2 = phoneWords.get(1);
        assertEquals("782792771", phoneWord2.getPhoneNumber());
        assertEquals(1, phoneWord2.getPhoneWords().size());
        assertEquals("STAR-WARS-1", phoneWord2.getPhoneWords().get(0));
    }

    @Test
    public void testGetPhoneWords_NoMatch() {
        phoneNumbers.clear();
        phoneNumbers.add("12345");
        PhoneWordMatcher phoneWordMatcher = new PhoneWordMatcher(dictionary, phoneNumbers);
        List<PhoneWord> phoneWords = phoneWordMatcher.getPhoneWords();

        assertEquals(1, phoneWords.size());

        PhoneWord phoneWord = phoneWords.get(0);
        assertEquals("12345", phoneWord.getPhoneNumber());
        assertEquals(1, phoneWord.getPhoneWords().size());
        assertEquals("No match found", phoneWord.getPhoneWords().get(0));
    }
}