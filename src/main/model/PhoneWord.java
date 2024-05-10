package model;

import java.util.List;

public class PhoneWord {
    private String phoneNumber;
    private List<String> phoneWords;


    public PhoneWord(String phoneNumber, List<String> phoneWords) {
        this.phoneNumber = phoneNumber;
        this.phoneWords = phoneWords;
    }

    public PhoneWord() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getPhoneWords() {
        return phoneWords;
    }

    public void setPhoneWords(List<String> phoneWords) {
        this.phoneWords = phoneWords;
    }
}
