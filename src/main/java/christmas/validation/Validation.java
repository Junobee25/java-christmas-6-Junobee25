package christmas.validation;

import christmas.configuration.MenuType;
import christmas.view.ErrorMessage;

public class Validation {
    private final static String REST = ",";
    private final static String DASH = "-";
    private static final int MENU_INDEX = 0;
    private static final int COUNT_INDEX = 1;
    private final static int ELEMENT_LENGTH = 3;

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

    public static void validateInputString(String userInput) {
        String[] selectFoods = userInput.split(REST);

        for (String item : selectFoods) {
            if (!item.trim().contains(DASH)) {
                ErrorMessage.inputMenuError();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateFoodArrayElement(String[] selectFoods) {
        for (String item : selectFoods) {
            String[] element = item.split(DASH);
            if (element.length != ELEMENT_LENGTH) {
                ErrorMessage.inputMenuError();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateElementFood(String[] selectFood) {
        for (String item : selectFood) {
            String[] element = item.split(DASH);
            String menu = element[MENU_INDEX];
            if (!MenuType.MENU.getMenuList().contains(menu)) {
                ErrorMessage.inputMenuError();
                throw new IllegalArgumentException();
            }
        }
    }
}
