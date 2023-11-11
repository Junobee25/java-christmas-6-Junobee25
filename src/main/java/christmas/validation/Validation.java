package christmas.validation;

import christmas.view.ErrorMessage;

public class Validation {
    public static void validateStringToInteger(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            ErrorMessage.inputDateError();
            throw new IllegalArgumentException();
        }
    }
}
