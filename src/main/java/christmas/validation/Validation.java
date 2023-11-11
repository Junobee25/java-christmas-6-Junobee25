package christmas.validation;

import christmas.configuration.MenuType;
import christmas.view.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validation {
    private final static String REST = ",";
    private final static String DASH = "-";
    private static final int MENU_INDEX = 0;
    private static final int COUNT_INDEX = 1;
    private final static int ELEMENT_LENGTH = 2;

    public static void validateEmptyInput(String userInput) {
        if (userInput.length() == 0) {
            ErrorMessage.inputDateError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateEmptyArray(String[] userInput) {
        if (userInput.length == 0) {
            ErrorMessage.inputMenuError();
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
        validateEmptyArray(selectFoods);

        for (String item : selectFoods) {
            if (!item.trim().contains(DASH)) {
                System.out.println("1");
                ErrorMessage.inputMenuError();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateFoodArrayElement(String[] selectFoods) {
        for (String item : selectFoods) {
            String[] element = item.split(DASH);
            if (element.length != ELEMENT_LENGTH) {
                System.out.println(2);
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
                System.out.println(3);
                ErrorMessage.inputMenuError();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateElementCount(String[] selectFood) {
        for (String item : selectFood) {
            String[] element = item.split(DASH);
            validateStringToInteger(element[COUNT_INDEX]);
            if (Integer.parseInt(element[COUNT_INDEX]) > 20 || Integer.parseInt(element[COUNT_INDEX]) <= 0) {
                System.out.println(4);
                ErrorMessage.inputMenuError();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateDuplicationElementFood(String[] selectFood) {
        List<String> foodOrder = new ArrayList<>();

        for (String item : selectFood) {
            String[] element = item.split(DASH);
            if (foodOrder.contains(element[MENU_INDEX])){
                System.out.println(5);
                ErrorMessage.inputMenuError();
                throw new IllegalArgumentException();
            }
            if (!foodOrder.contains(element[MENU_INDEX])) {
                foodOrder.add(element[MENU_INDEX]);
            }
        }
    }
}
