package christmas.util;

import christmas.configuration.BadgeType;
import christmas.configuration.DiscountType;
import christmas.configuration.MenuType;
import christmas.service.ChristmasService;
import christmas.validation.Validation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    private static final String CHRISTMAS_EVENT = "크리스마스 디데이 할인";
    private static final String WEEKDAY_EVENT = "평일 할인";
    private static final String WEEKEND_EVENT = "주말 할인";
    private static final String SPECIAL_EVENT = "특별 할인";
    private static final String GIVE_WAY_EVENT = "증정 이벤트";
    private static final String COMMAS = ",";
    private static final String DASH = "-";
    private static final int MENU_INDEX = 0;
    private static final int COUNT_INDEX = 1;

    public static int stringDateToInteger(String userInput) {
        Validation.validateDateEmptyInput(userInput);
        Validation.validateDateStringToInteger(userInput);
        Validation.validateRangeDate(Integer.parseInt(userInput));

        return Integer.parseInt(userInput);
    }

    public static int stringOrderToInteger(String userInput) {
        Validation.validateOrderEmptyInput(userInput);
        Validation.validateOrderStringToInteger(userInput);

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
        Validation.validateOrderEmptyInput(userInput);
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

    public static Map<String, Integer> makeDiscountMap(int date, Map<String, Integer> order, int totalPrice) {
        Map<String, Integer> eventDiscounts = new HashMap<>();
        ChristmasService christmasService = new ChristmasService();

        eventDiscounts.put(CHRISTMAS_EVENT, christmasService.totalChristmasDiscount(date));
        eventDiscounts.put(WEEKDAY_EVENT, christmasService.totalDessertDiscount(date, order));
        eventDiscounts.put(WEEKEND_EVENT, christmasService.totalMainDiscount(date, order));
        eventDiscounts.put(GIVE_WAY_EVENT, christmasService.totalGiveWayBenefit(totalPrice));
        eventDiscounts.put(SPECIAL_EVENT, christmasService.totalSpecialDiscount(date));

        return eventDiscounts;
    }

    public static String searchBenefitBadge(int totalBenefit) {
        if (totalBenefit >= BadgeType.SANTA.getBenefit()) {
            return BadgeType.SANTA.getBadge();
        }
        if (totalBenefit >= BadgeType.TREE.getBenefit()) {
            return BadgeType.TREE.getBadge();
        }
        if (totalBenefit >= BadgeType.STAR.getBenefit()) {
            return BadgeType.STAR.getBadge();
        }
        return BadgeType.NONE_BADGE.getBadge();
    }
}
