package christmas.service;

import christmas.configuration.DessertType;
import christmas.configuration.DiscountType;
import christmas.configuration.MainType;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChristmasService {

    public int calculateTotalDiscount(int currentDate, Map<String, Integer> order) {
        int dessertDiscount = 0;
        int mainDiscount = 0;
        int christmasDiscount = 0;

        // 받을 수 있는 할인 정책들
        List<DiscountType> discountTypes = findDiscountType(currentDate);

        // 각 할인 정책들에 대해 계산
        for (DiscountType type : discountTypes) {
            // 평일 할인에 해당 되면
            if (type == DiscountType.WEEKDAY) {
                // 전체 주문서를 확인 중
                for (Map.Entry<String, Integer> menuType : order.entrySet()) {
                    // 디저트 메뉴를 확인 중 ex) 초코케익, 아이스크림
                    for (DessertType dessertType : DessertType.values()) {
                        // 만약 초코케익과 아이스크림을 주문했다면
                        if (menuType.getKey().contains(dessertType.getMenuName())) {
                            // 각 디저트 메뉴마다 평일 할인 정책을 적용하여 디저트 할인 금액을 계산
                            dessertDiscount += DiscountType.WEEKDAY.calculate(dessertType.getPrice());
                        }
                    }
                }
            }
            if (type == DiscountType.WEEKEND) {
                for (Map.Entry<String, Integer> menuType : order.entrySet()) {
                    for (MainType mainType : MainType.values()) {
                        if (menuType.getKey().contains(mainType.getMenuName())) {
                            mainDiscount += DiscountType.WEEKEND.calculate(mainType.getPrice());
                        }
                    }
                }
            }
            if (type == DiscountType.CHRISTMAS) {
                christmasDiscount += DiscountType.CHRISTMAS.calculate(currentDate);
            }
        }
        return dessertDiscount + mainDiscount + christmasDiscount;
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
