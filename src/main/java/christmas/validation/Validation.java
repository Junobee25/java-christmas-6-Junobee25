package christmas.validation;

import christmas.view.ErrorMessage;

public class Validation {
    public static void validateEmptyInputDate(String userInput) {
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
}
