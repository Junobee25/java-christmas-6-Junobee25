package christmas.util;

import christmas.validation.Validation;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    private static final String COMMAS = ",";
    private static final String DASH = "-";
    private static final int MENU_INDEX = 0;
    private static final int COUNT_INDEX = 1;

    public static int stringToInteger(String userInput) {
        Validation.validateEmptyInput(userInput);
        Validation.validateStringToInteger(userInput);
        Validation.validateRangeDate(userInput);

        return Integer.parseInt(userInput);
    }


    public static Map<String, Integer> stringToMap(String userInput) {
        String[] selectFoods = stringToArray(userInput);
        Map<String, Integer> order = new HashMap<>();

        Validation.validateFoodArrayElement(selectFoods);
        Validation.validateElementFood(selectFoods);
        Validation.validateElementCount(selectFoods);
        Validation.validateDuplicationElementFood(selectFoods);

        for (String item : selectFoods) {
            order.put(item.split(DASH)[MENU_INDEX], Integer.parseInt(item.split(DASH)[COUNT_INDEX]));
        }

        return order;
    }

    private static String[] stringToArray(String userInput) {
        Validation.validateEmptyInput(userInput);
        Validation.validateInputString(userInput);
        // validation
        return userInput.split(COMMAS);
    }

}
