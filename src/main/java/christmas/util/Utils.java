package christmas.util;

import christmas.configuration.DiscountType;
import christmas.configuration.MenuType;
import christmas.validation.Validation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static String formatPriceToWonType(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(price);
    }

    public static int countPurchaseAmount(Map<String, Integer> order) {
        int amount = 0;

        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            amount += menu.getValue();
        }
        return amount;
    }

    public static List<DiscountType> findDiscountType(int currentDate) {
        List<DiscountType> discountTypes = new ArrayList<>();

        for (DiscountType type : DiscountType.values()) {
            if (type.getDates().contains(currentDate)) {
                discountTypes.add(type);
            }
        }
        return discountTypes;
    }

    public static MenuType findMenuType(MenuType menuType, Map<String, Integer> order) {
        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            if (menuType.getMenuList().contains(menu.getKey())) {
                return menuType;
            }
        }
        return MenuType.DEFAULT;
    }
}
