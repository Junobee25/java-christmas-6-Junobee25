package christmas.service;

import christmas.configuration.*;
import christmas.util.Utils;

import java.util.List;
import java.util.Map;

public class ChristmasService {
    private static final int GIVE_WAY_DISCOUNT = 25000;
    private static final int SPECIAL_DISCOUNT = 1000;
    private static final int ONE_HUNDRED_TWELVE_THOUSAND = 120000;
    private static final int ZERO = 0;

    public int calculateTotalPurchaseAmount(Map<String, Integer> order) {
        int appetizerPurchaseAmount = totalAppetizerPurchaseAmount(order);
        int mainPurchaseAmount = totalMainPurchaseAmount(order);
        int dessertPurchaseAmount = totalDessertPurchaseAmount(order);
        int beveragePurchaseAmount = totalBeveragePurchaseAmount(order);

        return appetizerPurchaseAmount + mainPurchaseAmount + dessertPurchaseAmount + beveragePurchaseAmount;

    }

    private int totalAppetizerPurchaseAmount(Map<String, Integer> order) {
        int appetizerPurchaseAmount = 0;

        for (AppetizerType appetizerType : AppetizerType.values()) {
            appetizerPurchaseAmount += calculateAppetizerPurchaseAmount(appetizerType, order);
        }
        return appetizerPurchaseAmount;
    }

    private int totalMainPurchaseAmount(Map<String, Integer> order) {
        int mainPurchaseAmount = 0;

        for (MainType mainType : MainType.values()) {
            mainPurchaseAmount += calculateMainPurchaseAmount(mainType, order);
        }
        return mainPurchaseAmount;
    }

    private int totalDessertPurchaseAmount(Map<String, Integer> order) {
        int dessertPurchaseAmount = 0;

        for (DessertType dessertType : DessertType.values()) {
            dessertPurchaseAmount += calculateDessertPurchaseAmount(dessertType, order);

        }
        return dessertPurchaseAmount;
    }

    private int totalBeveragePurchaseAmount(Map<String, Integer> order) {
        int beveragePurchaseAmount = 0;

        for (BeverageType beverageType : BeverageType.values()) {
            beveragePurchaseAmount += calculateBeveragePurchaseAmount(beverageType, order);
        }
        return beveragePurchaseAmount;
    }

    private int calculateAppetizerPurchaseAmount(AppetizerType appetizerType, Map<String, Integer> order) {
        int appetizerPurchaseAmount = 0;

        for (Map.Entry<String, Integer> menuType : order.entrySet()) {
            if (appetizerType.getMenuName().equals(menuType.getKey())) {
                appetizerPurchaseAmount += appetizerType.getPrice() * menuType.getValue();
            }
        }
        return appetizerPurchaseAmount;
    }

    private int calculateMainPurchaseAmount(MainType mainType, Map<String, Integer> order) {
        int mainPurchaseAmount = 0;

        for (Map.Entry<String, Integer> menuType : order.entrySet()) {
            if (mainType.getMenuName().equals(menuType.getKey())) {
                mainPurchaseAmount += mainType.getPrice() * menuType.getValue();
            }
        }
        return mainPurchaseAmount;
    }

    private int calculateDessertPurchaseAmount(DessertType dessertType, Map<String, Integer> order) {
        int dessertPurchaseAmount = 0;

        for (Map.Entry<String, Integer> menuType : order.entrySet()) {
            if (dessertType.getMenuName().equals(menuType.getKey())) {
                dessertPurchaseAmount += dessertType.getPrice() * menuType.getValue();
            }
        }
        return dessertPurchaseAmount;
    }

    private int calculateBeveragePurchaseAmount(BeverageType beverageType, Map<String, Integer> order) {
        int beveragePurchaseAmount = 0;

        for (Map.Entry<String, Integer> menuType : order.entrySet()) {
            if (beverageType.getMenuName().equals(menuType.getKey())) {
                beveragePurchaseAmount += beverageType.getPrice() * menuType.getValue();
            }
        }
        return beveragePurchaseAmount;
    }

    public int calculateTotalBenefit(int currentDate, Map<String, Integer> order) {
        int dessertDiscount = totalDessertDiscount(currentDate, order);
        int mainDiscount = totalMainDiscount(currentDate, order);
        int christmasDiscount = totalChristmasDiscount(currentDate);

        if (calculateTotalPurchaseAmount(order) > ONE_HUNDRED_TWELVE_THOUSAND) {
            return dessertDiscount + mainDiscount + christmasDiscount + totalSpecialDiscount(currentDate) + GIVE_WAY_DISCOUNT;
        }
        return dessertDiscount + mainDiscount + christmasDiscount + totalSpecialDiscount(currentDate);
    }

    public int calculateTotalDiscount(int currentDate, Map<String, Integer> order) {
        int dessertDiscount = totalDessertDiscount(currentDate, order);
        int mainDiscount = totalMainDiscount(currentDate, order);
        int christmasDiscount = totalChristmasDiscount(currentDate);

        return dessertDiscount + mainDiscount + christmasDiscount + totalSpecialDiscount(currentDate);
    }

    public int totalDessertDiscount(int currentDate, Map<String, Integer> order) {
        int dessertDiscount = 0;
        List<DiscountType> discountTypes = Utils.findDiscountType(currentDate);

        if (discountTypes.contains(DiscountType.WEEKDAY)) {
            for (Map.Entry<String, Integer> menuType : order.entrySet()) {
                dessertDiscount += calculateDessertDiscount(menuType);
            }
        }
        return dessertDiscount;
    }

    public int totalMainDiscount(int currentDate, Map<String, Integer> order) {
        int mainDiscount = 0;
        List<DiscountType> discountTypes = Utils.findDiscountType(currentDate);

        if (discountTypes.contains(DiscountType.WEEKEND)) {
            for (Map.Entry<String, Integer> menuType : order.entrySet()) {
                mainDiscount += calculatorMainDiscount(menuType);
            }
        }
        return mainDiscount;
    }

    public int totalChristmasDiscount(int currentDate) {
        int christmasDiscount = 0;
        List<DiscountType> discountTypes = Utils.findDiscountType(currentDate);

        if (discountTypes.contains(DiscountType.CHRISTMAS)) {
            christmasDiscount += DiscountType.CHRISTMAS.calculate(currentDate);
        }
        return christmasDiscount;
    }

    public int totalSpecialDiscount(int currentDate) {
        if (DiscountType.SPECIAL.getDates().contains(currentDate)) {
            return SPECIAL_DISCOUNT;
        }
        return ZERO;
    }

    public int totalGiveWayBenefit(int totalPrice) {
        if (totalPrice > ONE_HUNDRED_TWELVE_THOUSAND) {
            return GIVE_WAY_DISCOUNT;
        }
        return ZERO;
    }

    private int calculateDessertDiscount(Map.Entry<String, Integer> menuType) {
        int dessertDiscount = 0;
        for (DessertType dessertType : DessertType.values()) {
            if (menuType.getKey().contains(dessertType.getMenuName())) {
                dessertDiscount += (dessertType.getPrice() - DiscountType.WEEKDAY.calculate(dessertType.getPrice())) * menuType.getValue();
            }
        }
        return dessertDiscount;

    }


    private int calculatorMainDiscount(Map.Entry<String, Integer> menuType) {
        int mainDiscount = 0;
        for (MainType mainType : MainType.values()) {
            if (menuType.getKey().contains(mainType.getMenuName())) {
                mainDiscount += (mainType.getPrice() - DiscountType.WEEKEND.calculate(mainType.getPrice())) * menuType.getValue();
            }
        }
        return mainDiscount;
    }
}
