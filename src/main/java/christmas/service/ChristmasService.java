package christmas.service;

import christmas.configuration.DessertType;
import christmas.configuration.DiscountType;
import christmas.configuration.MainType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChristmasService {

    public int calculateTotalDiscount(int currentDate, Map<String, Integer> order) {
        int dessertDiscount = totalDessertDiscount(currentDate, order);
        int mainDiscount = totalMainDiscount(currentDate, order);
        int christmasDiscount = totalChristmasDiscount(currentDate);

        return dessertDiscount + mainDiscount + christmasDiscount;
    }

    private int totalDessertDiscount(int currentDate, Map<String, Integer> order) {
        int dessertDiscount = 0;
        List<DiscountType> discountTypes = findDiscountType(currentDate);

        if (discountTypes.contains(DiscountType.WEEKDAY)) {
            for (Map.Entry<String, Integer> menuType : order.entrySet()) {
                dessertDiscount = calculateDessertDiscount(menuType);
            }
        }

        return dessertDiscount;
    }

    private int calculateDessertDiscount(Map.Entry<String, Integer> menuType) {
        int dessertDiscount = 0;
        for (DessertType dessertType : DessertType.values()) {
            if (menuType.getKey().contains(dessertType.getMenuName())) {
                dessertDiscount += DiscountType.WEEKDAY.calculate(dessertType.getPrice());
            }
        }
        return dessertDiscount;

    }

    private int totalMainDiscount(int currentDate, Map<String, Integer> order) {
        int mainDiscount = 0;
        List<DiscountType> discountTypes = findDiscountType(currentDate);

        if (discountTypes.contains(DiscountType.WEEKEND)) {
            for (Map.Entry<String, Integer> menuType : order.entrySet()) {
                mainDiscount = calculatorMainDiscount(menuType);
            }
        }

        return mainDiscount;
    }

    private int calculatorMainDiscount(Map.Entry<String, Integer> menuType) {
        int mainDiscount = 0;
        for (MainType mainType : MainType.values()) {
            if (menuType.getKey().contains(mainType.getMenuName())) {
                mainDiscount += mainType.getPrice() - DiscountType.WEEKEND.calculate(mainType.getPrice());
            }
        }
        return mainDiscount;
    }

    private int totalChristmasDiscount(int currentDate) {
        int christmasDiscount = 0;
        List<DiscountType> discountTypes = findDiscountType(currentDate);

        if (discountTypes.contains(DiscountType.CHRISTMAS)) {
            christmasDiscount += DiscountType.CHRISTMAS.calculate(currentDate);
        }

        return christmasDiscount;
    }


    private static List<DiscountType> findDiscountType(int currentDate) {
        List<DiscountType> discountTypes = new ArrayList<>();

        for (DiscountType type : DiscountType.values()) {
            if (type.getDates().contains(currentDate)) {
                discountTypes.add(type);
            }
        }
        return discountTypes;
    }

}
