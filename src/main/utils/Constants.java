package utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final Map<Character, String> CHARACTER_STRING_MAP = new HashMap<>();
    public static final String ARGS_DICTIONARY = "-dictionary";
    public static final String ARGS_INPUT = "-input";
    public static final String ERROR_MSG_MISSING_DICTIONARY = "ERROR: please specify the 'dictionary.txt' file path.";
    public static final String ERROR_MSG_MISSING_INPUT = "ERROR: please specify the 'input.txt' file path.";
    public static final String NO_MATCH_FOUND_MSG = "No match found";

    static {
        CHARACTER_STRING_MAP.put('2', "ABC");
        CHARACTER_STRING_MAP.put('3', "DEF");
        CHARACTER_STRING_MAP.put('4', "GHI");
        CHARACTER_STRING_MAP.put('5', "JKL");
        CHARACTER_STRING_MAP.put('6', "MNO");
        CHARACTER_STRING_MAP.put('7', "PQRS");
        CHARACTER_STRING_MAP.put('8', "TUV");
        CHARACTER_STRING_MAP.put('9', "WXYZ");
    }
}
