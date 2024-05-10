import model.PhoneWord;
import service.PhoneWordMatcher;
import utils.Constants;
import utils.Utils;

import java.util.List;
import java.util.Map;


public class PhoneWordApplication {

    public static void main(String[] args) throws Exception {
        String dictionaryFilePath = Utils.getArgumentValue(Constants.ARGS_DICTIONARY, args);
        String phoneInputFilePath = Utils.getArgumentValue(Constants.ARGS_INPUT, args);
        if (dictionaryFilePath.isEmpty()) {
            throw new Exception(Constants.ERROR_MSG_MISSING_DICTIONARY);
        }
        if (phoneInputFilePath.isEmpty()) {
            throw new Exception(Constants.ERROR_MSG_MISSING_INPUT);
        }

        Map<String, String> dictionary = Utils.loadDictionary(dictionaryFilePath);
        List<String> phoneNumbers = Utils.loadInput(phoneInputFilePath);

        PhoneWordMatcher phoneWordMatcher = new PhoneWordMatcher(dictionary, phoneNumbers);
        List<PhoneWord> phoneWrodsList = phoneWordMatcher.getPhoneWords();
        Utils.printOutcome(phoneWrodsList);
    }
}
