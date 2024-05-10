* The challenge 2 - phone word matcher has been selected. Because of it is more challenge than bike simulation and personally more interested with this problem. 

# Solution and Design 

The idea is to match the words provided in the dictionary to the phone number digit by digit. Since one digit could be mapped with multiple letters, converting the words to digits format first would be more convenient for matching and comparing. Then we only need to match the phone numbers with the dictionary regressively until a possible phone word is found, or two consecutive digits remain unchanged. Using dynamic programming could solve this problem. Below is the psudo code for the solution. 

```
List<String> dictionaryWords = loadDictionary()
List<String> phoneNumbers = loadPhoneNumber()

Map<word, digits> dictionary 
for word in dictionaryWords: 
    wordDigits = WordToDigits(word)
    dictionary.add(word, wordDigits)

for phoneNumber in phoneNumbers: 
    List<String> phoneWordList
    PhoneWordMatcher(phoneWordList, index=0, unchangeCount=0, phoneWord, phoneNumber)

PhoneWordMatcher(phoneWordList, index, unchangeCount, phoneWord, phoneNumber):
    // it is not allowed that two consecutive digits remain unchanged
    if unchangeCound less than 2:
        // if index moved to the end, add the matched phone word to the list 
        if index == phoneNumber:
            phoneWordList.add(phoneWord)
        else: 
            // loop through the dictionary to check if any word matches the number
            for word in dictionary.keys():
                digits = dicitonary.get(word)
                // if find word matches, calling the function itself with updated index and phoneWord.
                if digits==phoneNumber[index, index+ digits.length()]:
                    PhoneWordMatcher(phoneWordList, index+digits.length(), unchangeCount=0, phoneWord+word, phoneNumber)
            // No match found, move the index to next index and add 1 to unchangeCount
            PhoneWordMatcher(phoneWordList, index+1, unchangeCount+1, phoneWord, phoneNumber)

```

# Submitted files

* `src`: Source code folder. Contains source and test code.
* `Phonewords.jar`: Jar file for the solution.
* `dictionary.txt`: Sample dictionary file. The file should only contains alphabetic words and one word per line. Non-alphabetic characters will be filter out while loading dictionary to the application. 
* `input.txt`: Sample input file. The file should only contains numeric characters and one phone number per line. Non-numeric characters will be filter out while loading dictionary to the application.

# Excuting the code

### `Runing Jar file:`

1. Open Command Prompt from the Phonewords.jar directory.
2. Run `Java -jar Phonewords.jar -dictionary dictionary.txt -input input.txt`

Sample Output: 

```
C:\Users\Michael Lyu-Coding Challenge 2>Java -jar Phonewords.jar -dictionary dictionary.txt -input input.txt
00998776
No match found

782792771
STAR-WARS-1
```

### `Running source code`

1. Import the `src` folder to any Java IDE.
2. Go to `src -> main -> PhoneWordApplication.java`.
3. Run the main method.
