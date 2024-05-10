package service;


import model.PhoneWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static utils.Constants.NO_MATCH_FOUND_MSG;


public class PhoneWordMatcher {
    private static Map<String, String> dictionary;
    private static List<String> phoneNumbers;

    public PhoneWordMatcher(Map<String, String> dictionary, List<String> phoneNumbers) {
        PhoneWordMatcher.dictionary = dictionary;
        PhoneWordMatcher.phoneNumbers = phoneNumbers;
    }


    /**
     * Matching the phone words with given dictionary
     * and phone numbers
     *
     * @return list of matched phone words
     */
    public List<PhoneWord> getPhoneWords() {
        List<PhoneWord> phoneWordList = new ArrayList<>();
        for (String phoneNumber : phoneNumbers) {
            PhoneWord phoneWord = generatePhoneWord(phoneNumber);
            phoneWordList.add(phoneWord);
        }
        return phoneWordList;
    }

    /**
     * Generating the matched phone word list
     *
     * @param phoneNumber
     * @return
     */
    private PhoneWord generatePhoneWord(String phoneNumber) {
        List<String> possiblePhoneWords = new ArrayList<>();
        matchingPhoneWord(phoneNumber, possiblePhoneWords, 0, "", 0);
        if (possiblePhoneWords.isEmpty()) {
            possiblePhoneWords.add(NO_MATCH_FOUND_MSG);
        }
        return new PhoneWord(phoneNumber, possiblePhoneWords);
    }

    /**
     * Matching possible phone words for single
     * phone number
     *
     * @param phoneNumber
     * @param possiblePhoneWords
     * @param index
     * @param combination
     * @param unchangedCount
     */
    private void matchingPhoneWord(String phoneNumber, List<String> possiblePhoneWords
            , int index, String combination, int unchangedCount) {
        if (unchangedCount < 2) {
            if (index >= phoneNumber.length()) {
                possiblePhoneWords.add(combination);
            } else {
                for (String word : dictionary.keySet()) {
                    if (index + word.length() - 1 < phoneNumber.length()) {
                        if (phoneNumber.substring(index, index + word.length()).equals(dictionary.get(word))) {
                            String combinationTemp = combination.isEmpty() ? word : combination + "-" + word;
                            matchingPhoneWord(phoneNumber, possiblePhoneWords, index + word.length(), combinationTemp, 0);
                        }
                    }
                }
                matchingPhoneWord(phoneNumber, possiblePhoneWords, index + 1,
                        combination + "-" + phoneNumber.charAt(index), unchangedCount + 1);
            }
        }
    }

}
