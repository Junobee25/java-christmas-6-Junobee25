package christmas.validation;

import christmas.view.ErrorMessage;

public class Validation {
    private final static String REST = ",";
    private final static String DASH = "-";

    public static void validateEmptyInput(String userInput) {
        if (userInput.length() == 0) {
            ErrorMessage.inputDateError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateStringToInteger(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit)) {
            ErrorMessage.inputDateError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateRangeDate(String userInput) {
        int date = Integer.parseInt(userInput);

        if (date < 1 || date > 31) {
            ErrorMessage.inputDateError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputOrder(String userInput) {
        String[] selectFoods = userInput.split(REST);

        for (String item : selectFoods) {
            if (!item.trim().contains(DASH)) {
                ErrorMessage.inputMenuError();
                throw new IllegalArgumentException();
            }
        }
    }
}
