package utils;


import model.PhoneWord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.IntStream;

import static utils.Constants.CHARACTER_STRING_MAP;


public class Utils {
    /**
     * convert single letter to digit number
     *
     * @param letter
     * @return
     */
    private static Character charToDigit(Character letter) {
        for (Character key : CHARACTER_STRING_MAP.keySet()) {
            if (CHARACTER_STRING_MAP.get(key).contains(String.valueOf(letter))) {
                return key;
            }
        }
        return null;
    }

    /**
     * convert word to digits
     *
     * @param word
     * @return
     */
    public static String wordToDigits(String word) {
        String digits = "";
        for (Character letter : word.toCharArray()) {
            digits += charToDigit(letter);
        }
        return digits;
    }


    /**
     * load dictionary file
     *
     * @param fileName
     * @return
     */
    public static Map<String, String> loadDictionary(String fileName) {
        Map<String, String> dictionary = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String word = scanner.nextLine().trim().replaceAll("\\P{Alpha}", "").toUpperCase();
                if (!word.isEmpty()){
                    String wordDigits = wordToDigits(word);
                    dictionary.put(word, wordDigits);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dictionary;
    }

    /**
     * load input file (phone numbers)
     *
     * @param fileName
     * @return
     */
    public static List<String> loadInput(String fileName) {
        List<String> phoneNumbers = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String phoneNumber = scanner.nextLine().trim().replaceAll("\\D", "");
                if (!phoneNumber.isEmpty()){
                    phoneNumbers.add(phoneNumber);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return phoneNumbers;
    }

    /**
     * get argument value from command-line argument
     *
     * @param arg
     * @param inputs
     * @return
     */
    public static String getArgumentValue(String arg, String[] inputs) {
        String argValue = "";
        int argIndex = IntStream.range(0, inputs.length)
                .filter(i -> inputs[i].equals(arg))
                .findFirst()
                .orElse(-1);
        argValue = (argIndex == -1 || argIndex >= inputs.length) ? "" : inputs[argIndex + 1];
        if (!argValue.contains(".txt")) {
            argValue = "";
        }
        return argValue;
    }

    /**
     * print phone numbers and corresponding phone words
     *
     * @param phoneWrodsList
     */
    public static void printOutcome(List<PhoneWord> phoneWrodsList) {
        for (PhoneWord phoneWord : phoneWrodsList) {
            System.out.println(phoneWord.getPhoneNumber());
            phoneWord.getPhoneWords().stream().forEach(s -> System.out.println(s));
            System.out.println();
        }
    }
}
