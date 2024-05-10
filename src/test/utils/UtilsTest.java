package utils;

import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    private Utils utils = new Utils();

    @Test
    void wordToDigits() {
        assertEquals("54889", utils.wordToDigits("KITTY"));
        assertEquals("7827", utils.wordToDigits("STAR"));
        assertEquals("9277", utils.wordToDigits("WARS"));
    }


    @Test
    void getArgumentValue() {
        String[] inputs = {"-dictionary", "dictionary.txt", "-input", "input.txt"};
        assertEquals("dictionary.txt", Utils.getArgumentValue("-dictionary", inputs));
        assertEquals("", Utils.getArgumentValue("-x", inputs));
        assertEquals("", Utils.getArgumentValue("-o", new String[]{}));
    }

    @Test
    public void testLoadDictionary() {
        Map<String, String> dictionary = Utils.loadDictionary("resources/dictionary.txt");
        assertNotNull(dictionary);
        assertEquals(6, dictionary.size());
        assertEquals("54889", dictionary.get("KITTY"));
        assertEquals("96753", dictionary.get("WORLD"));
    }

    @Test
    public void testLoadInput() {
        List<String> phoneNumbers = Utils.loadInput("resources/input.txt");
        assertNotNull(phoneNumbers);
        assertEquals(2, phoneNumbers.size());
        assertEquals("54889", phoneNumbers.get(0));
        assertEquals("782792771", phoneNumbers.get(1));
    }
}